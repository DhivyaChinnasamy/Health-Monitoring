
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java.2
 */
public class EmployeeLogin extends HttpServlet {
    String username="";
    String password="";
    String type1="",key="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        username = req.getParameter("username");
        password = req.getParameter("password");
       
	
	HttpSession sn = req.getSession(true);
     sn.setAttribute("username",username);
     
		RequestDispatcher rd = null;
                
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");
            st = con.createStatement();
            rs = st.executeQuery("select * from empdetails where empid='"+username+"' && password='"+password+"'");
            if(rs.next()) {
            
                String query = "delete from chat where username = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, username);

      // execute the preparedstatement
      preparedStmt.execute();
                   
                rd=req.getRequestDispatcher("EmployeePage.jsp");
            }
            
            else {
  
               rd=req.getRequestDispatcher("failure.jsp");
	        }
	     rd.forward(req,res);
        }
        catch(Exception e2)
         {
            System.out.println("Exception : "+e2.toString());
        }
    }
}
