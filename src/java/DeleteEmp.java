
   import java.io.*;
   import java.sql.*;
   import javax.servlet.*;
   import javax.servlet.http.*;
   import java.lang.*;
import java.text.DecimalFormat;
 
public class DeleteEmp extends HttpServlet {

Connection con=null;
    Statement st=null,st1=null;
    ResultSet rs=null;
    RequestDispatcher rd=null;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
 
            
            HttpSession sn = req.getSession(true);
     
	        String empid= req.getParameter("empid");
               
        	RequestDispatcher rd;

	try {
		
		
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");
            String query = "delete from empdetails where empid = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, empid);

      // execute the preparedstatement
      preparedStmt.execute();
            
            rd=req.getRequestDispatcher("ViewEmployee.jsp");
            rd.forward(req,res);
        } catch(Exception e2) {
            // rd=req.getRequestDispatcher("failure.jsp");
            System.out.println(e2);
        }
    }
}