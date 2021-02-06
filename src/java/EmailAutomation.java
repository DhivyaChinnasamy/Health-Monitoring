
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java.2
 */
public class EmailAutomation extends HttpServlet {
    String username="";
    String password="";
    String type1="",key="";
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
        
	
	HttpSession sn = req.getSession(true);
     String host = "smtp.gmail.com";
                String from="securecomputing10@gmail.com";
                String subject = "Health Report";
		RequestDispatcher rd = null;
                
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");
            String query = "select * from iotdata"; 
                                            st = con.createStatement();
                                            rs = st.executeQuery(query);

                                            while (rs.next()) {
                                                
                                                String s1 = rs.getString(1);
                                                String s2 = rs.getString(2);
												
												String s3 = rs.getString(3);
                                                String s4 = rs.getString(4);
												
												String s5 = rs.getString(5);
                                                String s6 = rs.getString(6);
												 String s7 = rs.getString(7);
												  String s8 = rs.getString(8);
												  
												    int bloodsugar = Integer.parseInt(s4);
												  String bloodsugarreport = "";
												  if(bloodsugar<=140)
												  {
												  	bloodsugarreport="Normal";
												  }
												  else if(bloodsugar>140 && bloodsugar<=199)
												  {
												  	bloodsugarreport="Diabetes";
												  }
												  else if(bloodsugar>199)
												  {
												  	bloodsugarreport="Pre-diabetes";
												  }
												  
												  int oxygen = Integer.parseInt(s6);
												  String oxygenreport="";
												  if(oxygen>=96 && oxygen<=98)
												  {
												    oxygenreport="Normal";
												  }
												  else
												  {
												  	oxygenreport="Hypoxemia";
												  }
												 
												 int bp = Integer.parseInt(s2);
												 
												 int respiration = Integer.parseInt(s3);
												 String asthmareport="";
												 if(oxygen>=92 && oxygen<=95 && bp>=100 && bp<=125 && respiration>=20 && respiration<=30)
												  {
												  asthmareport="Asthma";
												  }
												 else
												 {
												 asthmareport="Normal";
												 } 
                   
               
                                                                                                 String data1="Diabetes status : "+bloodsugarreport+"\n Hypoxemia status : "+oxygenreport+"\n Asthma status : "+asthmareport;
                     String messageText = data1;
                     String email="";
                     st = con.createStatement();
            rs = st.executeQuery("select * from empdetails where empid='"+s8+"'");
            if(rs.next()) {
                email=rs.getString(6);
            
boolean sessionDebug = true;
// Create some properties and get the default Session.
//System.setProperty("smtp.protocols", "SSLv3");
Properties props = System.getProperties();

props.put("mail.smtp.starttls.enable","true");
props.setProperty("mail.transport.protocol","smtp");
props.setProperty("mail.host",host);
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "587");    //port is 587 for TLS  if you use SSL then port is 465
props.put("mail.debug", "true");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

Session mailSession = Session.getInstance(props, new javax.mail.Authenticator()
{
protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("UserName", "Password");
}
});
 
// Set debug on the Session
// Passing false will not echo debug info, and passing True will.
 
mailSession.setDebug(sessionDebug);
 
// Instantiate a new MimeMessage and fill it with the
// required information.
 
Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = {new InternetAddress(email)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(subject);
//msg.setSentDate(new Date());
msg.setText(messageText);


 
// Hand the message to the default transport service
// for delivery.
 
Transport transport = mailSession.getTransport("smtp");
transport.connect(host, "propsessionmail", "sessionpass");
transport.sendMessage(msg, msg.getAllRecipients()); 
}
               rd=req.getRequestDispatcher("MailSuccess.jsp");
	        }
	     rd.forward(req,res);
        }
        catch(Exception e2)
         {
            System.out.println("Exception : "+e2.toString());
        }
    }
}
