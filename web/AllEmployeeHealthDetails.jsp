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
.style36 {color: #000000}
.style37 {font-size: medium; color: #000000; }
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
              <td><div align="center"><a href="AddEmployee.jsp" class="style2">Manage Employee </a></div></td>
            </tr>
            <tr>
              <td><div align="center"><a href="SearchHealthDetails.jsp" class="style2">Search Health details </a></div></td>
            </tr>
            <tr>
              <td><div align="center"><a href="AllEmployeeHealthDetails.jsp" class="style2">All Employee Health details </a></div></td>
            </tr>
            <tr>
              <td><div align="center"><a href="adminlogin.jsp" class="style2">Logout</a></div></td>
            </tr>
          </table>
        </div></td>
        <td height="449"><div align="center">
          
            <h2 class="style3">All Employee Health Details </h2>
            <div class="mainbar">
              <div class="article style1">
                
                  <div align="center"></div>
                  <table width="797" height="224" border="0" >
                    <tr>
                      <td height="52" colspan="8" bgcolor="#006666"><div align="center"><span class="style24">View Employee Health Details </span></div></td>
                    </tr>
                    <tr>
                      <td width="88" bordercolor="#FFFFFF"><div align="center" class="style22">Emp Id </div></td>
                      <td width="130" bordercolor="#FFFFFF"><div align="center" class="style21"><span class="style22">Temperature</span></div></td>
                      <td width="144" bordercolor="#FFFFFF"><div align="center"><span class="style22">Blood Pressure </span></div></td>
                      <td width="118" bordercolor="#FFFFFF"><div align="center"><span class="style22">Respiration</span></div></td>
                      <td width="137" bordercolor="#FFFFFF"><div align="center"><span class="style22">Glucose</span></div></td>
                      <td width="154" bordercolor="#FFFFFF"><div align="center"><span class="style22">Heartrate</span></div></td>
                      <td width="154" bordercolor="#FFFFFF"><div align="center"><span class="style22">Oxygen Saturation </span></div></td>
                      <td width="154" bordercolor="#FFFFFF"><div align="center"><span class="style22">Electro Cardiogram </span></div></td>
                    </tr>
                    <%
                                        try {
                                         
							//String username, user;
        PreparedStatement ps;
        ResultSet rs;
		Connection con = null;
		Statement st,st1,st2,st3,st4;
                                            
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
												 
												  String heartreport="";
												 if(bp>=140)
												 {
												 	heartreport="Abnormal";
												 }
												  else
												 {
												 heartreport="Normal";
												 }
												 //String s7 = rs.getString(7);
                                               
                                               // String oriName[] = fileName.split("____");
                                               // oriName[1].split("\\.");
                                              //  String originalName =oriName[0]+"."+oriName[1].split("\\.")[1];
                                    %>
                    <tr>
                      <td><div align="center" class="style25 style36"><%=s8%></div></td>
                      <td><div align="center" class="style37"><%=s1%></div></td>
                      <td><div align="center" class="style37"><%=s2%></div></td>
                      <td><div align="center" class="style37"><%=s3%></div></td>
                      <td><div align="center" class="style37"><%=s4%></div></td>
                      <td><div align="center" class="style37"><%=s5%></div></td>
                      <td><div align="center" class="style36"><span class="style25"><%=s6%></span></div></td>
                      <td><div align="center" class="style36"><span class="style25"><%=s7%></span></div></td>
                    </tr>
					  <tr>
                      <td><span class="style22">Diabetes :</span></td>
                      <td><span class="style37 style26"><%=bloodsugarreport%></span></td>
                      <td><span class="style22">Hypoxemia :</span></td>
                      <td><span class="style37 style26"><%=oxygenreport%></span></td>
                      <td><span class="style22">Asthma :</span></td>
                      <td><span class="style37 style26"><%=asthmareport%></span></td>
                      <td><span class="style22">Coronary Heart Disease  :</span></td>
                      <td><span class="style36"><span class="style37 style26"><%=heartreport%></span></span></td>
                    </tr>
                    <tr>
                      <td colspan="8"><div align="center"></div></td>
                    </tr>
                    <%

                                            }
                                            con.close();
                                        } catch (Exception e) {
                                            out.println(e);
                                        }

                                    %>
                  </table>
                  <p align="center">&nbsp;</p>
               
              </div>
              <div class="article"></div>
            </div>
            <p>&nbsp;</p>
          
          </div></td>
      </tr>
      <tr>
        <td height="74" colspan="2" bgcolor="#006666">&nbsp;</td>
      </tr>
    </table>
    </body>
</html>
