<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Employee Health Monitoring</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
<!--
.style1 {
	font-size: x-large;
	color: #FFFFFF;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style2 {
	color: #006666;
	font-size: large;
}
.style3 {
	color: #006666;
	font-weight: bold;
}
.style21 {color: #687A66}
.style22 {font-size: medium;
	font-weight: bold;
}
.style22 {font-size: medium; font-weight: bold; color: #687A66; }
.style24 {color: #E1EAF1;
	font-size: 24px;
}
.style25 {font-size: medium}
.style26 {font-size: large}
-->
        </style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
    <body>
    <table width="100%" height="104%" border="0">
      <tr>
        <td width="18%" background="images/health.jpg" bgcolor="#FFFFFF">&nbsp;</td>
        <td width="82%" height="230" bgcolor="#006666"><div align="center" class="style1">Employee Health Monitoring </div></td>
      </tr>
      <tr>
        <td height="449"><div align="center">
          <table width="246" height="262" border="0">
            <tr>
              <td><div align="center"><a href="ViewHealthDetails.jsp" class="style2">View Health details </a><a href="AddEmployee.jsp" class="style2"></a></div></td>
            </tr>
            <tr>
              <td><div align="center"><a href="ChatBot.jsp" class="style2">Chat Bot </a></div></td>
            </tr>
            <tr>
              <td><div align="center"><a href="ViewDiagnosis.jsp" class="style2">View Diagnosis </a></div></td>
            </tr>
            <tr>
              <td><div align="center"><a href="emplogin.jsp" class="style2">Logout</a></div></td>
            </tr>
          </table>
        </div></td>
        <td height="449"><div align="center">
          
            <h2 class="style3">Chat Bot </h2>
            <table width="54%" height="190"  align="center" style="border:1px solid #000000;">
              <%
                                        try {
                                         
							//String username, user;
							String username = session.getAttribute("username").toString();
							String s1 = "Welcome "+username+",";
							String s2 = "How can I help you";
							s2 = s1+ " " + s2;
							%>
              <tr align="center" valign="middle" bgcolor="#89723A" style="font-weight:bold;">
                <td width="253" height="39" bgcolor="#EAF8EF">&nbsp;</td>
                <td width="264" bgcolor="#EAF8EF"><%=s2%></td>
              </tr>
              <%
        PreparedStatement ps;
        ResultSet rs;
		Connection con = null;
		Statement st,st1,st2,st3,st4;
                                            
                                            Class.forName("com.mysql.jdbc.Driver");
                                     con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/ZnrtgOH0r0","ZnrtgOH0r0","7vAeXso3N7");
                                             String query = "select * from chat where username='"+username+"'"; 
                                            st = con.createStatement();
                                            rs = st.executeQuery(query);

                                            while (rs.next()) {
                                                
                                                s1 = rs.getString(1);
                                                s2 = rs.getString(2);
												
												
												 
                                               
                                               // String oriName[] = fileName.split("____");
                                               // oriName[1].split("\\.");
                                              //  String originalName =oriName[0]+"."+oriName[1].split("\\.")[1];
                                    %>
              <tr align="center" valign="middle" bgcolor="#89723A" style="font-weight:bold;">
                <td height="42" bgcolor="#C8E2D1"><%=s1%></td>
                <td bgcolor="#C8E2D1">&nbsp;</td>
              </tr>
              <tr align="center" valign="middle" bgcolor="#89723A" style="font-weight:bold;">
                <td width="253" height="31" bgcolor="#EAF8EF">&nbsp;</td>
                <td width="264" bgcolor="#EAF8EF"><%=s2%></td>
              </tr>
              <%

                                            }
                                            con.close();
                                        } catch (Exception e) {
                                            out.println(e);
                                        }

                                    %>
            </table>
            <p><a href="chathistory.jsp" class="style26">Chat History </a></p>
          
          </div>
          <div align="center">
            <form name="form1" method="post" action="PostQuestions">
              <table width="315" height="84" border="0">
                <tr>
                  <td width="212"><span class="style26">Queries</span></td>
                  <td width="214"><label>
                    <textarea name="questions" id="questions"></textarea>
                  </label></td>
                  <td width="214"><input type="submit" name="Submit22" value="Send"></td>
                </tr>
              </table>
              <p>
                <label>
                <input name="username" type="text" id="username" style="visibility:hidden" value="<%=session.getAttribute("username")%>">
                </label>
              </p>
            </form>
          </div>
          <p align="center">&nbsp;</p></td>
      </tr>
      <tr>
        <td height="74" colspan="2" bgcolor="#006666">&nbsp;</td>
      </tr>
    </table>
    </body>
</html>
