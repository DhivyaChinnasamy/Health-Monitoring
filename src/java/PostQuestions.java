/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author java.2
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class PostQuestions extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
      String username = req.getParameter("username");
	   String questions= req.getParameter("questions");
           String answer="";
        	RequestDispatcher rd;
        
              String[] alldata= new String[50],alldata1= new String[50];
            
                String keyword="";
		
	try {
		
		
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");
            
             String query = "delete from tempanswer";
      PreparedStatement preparedStmt = con.prepareStatement(query);
     
      preparedStmt.execute();
            
            String[] questions1 = questions.split("[^0-9a-zA-Z]+",-1);
            String stopwords = "";
            String tokens = "";
          
                for(int i=0;i<questions1.length;i++)
                {
                    String inputword = questions1[i];
                    
                    Stopwords test = Stopwords.getStopWords();
                    System.out.println(inputword+" is a stopword:" + test.isStopWord(inputword));
                    
                    if(test.isStopWord(inputword))
                    {
                        stopwords = stopwords + inputword +" ";
                        tokens = tokens + inputword +"\n";
                    }
                    else
                    {
                       keyword = keyword + inputword +" ";
                       tokens = tokens + inputword +"\n";
                    }
                }
                System.out.println("Keyword : "+keyword);
                
                
                
                 st = con.createStatement();
            rs = st.executeQuery("select * from answers");
            while(rs.next()) {
                String dbans = rs.getString(1);
                
                    String[] questions2 = dbans.split("[^0-9a-zA-Z]+",-1);
                    String keyword1="";
                    for(int i=0;i<questions2.length;i++)
                {
                    String inputword = questions2[i];
                    
                    Stopwords test = Stopwords.getStopWords();
                    System.out.println(inputword+" is a stopword:" + test.isStopWord(inputword));
                    
                    if(test.isStopWord(inputword))
                    {
                       
                    }
                    else
                    {
                       keyword1 = keyword1 + inputword +" ";
                      
                    }
                }
                
                String dbans1 = rs.getString(2);
                int count = 0;
                alldata1 = keyword.split(" ");
                String[] alldata2 = keyword1.split(" ");
                for(int i=0;i<alldata1.length;i++)
                {
                    if(dbans.contains(alldata1[i]))
                    {
                        count++;
                    }
                }
                double score=(double)((double)count/(double)alldata2.length);
                st1 = con.createStatement();
          int add2=st1.executeUpdate("insert into tempanswer values('"+dbans1+"','"+score+"')");
            }
             
             st = con.createStatement();
            ResultSet rs2 = st.executeQuery("select * from tempanswer ORDER BY score DESC");
            if(rs2.next()) {
                
                double score = rs2.getDouble(2);
                if(score>0.2)
                {
                    answer = rs2.getString(1);
                }
                else
                {
                   answer = "Cant say"; 
                }
            }
            
            st1 = con.createStatement();
          int add=st1.executeUpdate("insert into chat values('"+questions+"','"+answer+"','"+username+"')");
          st1 = con.createStatement();
          int add2=st1.executeUpdate("insert into chathistory values('"+questions+"','"+answer+"','"+username+"')");
         sn.setAttribute("keyword",keyword);
          sn.setAttribute("tokens",tokens);
          sn.setAttribute("stopwords",stopwords);
          rd=req.getRequestDispatcher("ChatBot1.jsp");
            rd.forward(req,res);
           
        } catch(Exception e2)
         {
            System.out.println("Exception : "+e2.toString());
        }
    }
}