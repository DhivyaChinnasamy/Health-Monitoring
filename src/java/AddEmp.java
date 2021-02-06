
   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   import java.lang.*;
import java.text.DecimalFormat;
 
public class AddEmp extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
     
	        String empid= req.getParameter("empid");
                String password= req.getParameter("password");
                String empname= req.getParameter("empname");
               
                String empposition= req.getParameter("empposition");
        	String empdept= req.getParameter("empdept");
                String email= req.getParameter("emailid");
                String mobileno= req.getParameter("mobileno");
               
        	RequestDispatcher rd;

	try {
		
		
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");
            st = con.createStatement();
            rs = st.executeQuery("select * from empdetails where empid='"+empid+"'");
            if(rs.next()) {
                rd=req.getRequestDispatcher("EmpIDexists.jsp");
            rd.forward(req,res);
            }
            else
            {
            st1 = con.createStatement();
            int add=st1.executeUpdate("insert into empdetails values('"+empid+"','"+password+"','"+empname+"','"+empposition+"','"+empdept+"','"+email+"','"+mobileno+"')");
            rd=req.getRequestDispatcher("EmpSuccess.jsp");
            rd.forward(req,res);
            }
        } catch(Exception e2) {
            // rd=req.getRequestDispatcher("failure.jsp");
            System.out.println(e2);
        }
    }
}