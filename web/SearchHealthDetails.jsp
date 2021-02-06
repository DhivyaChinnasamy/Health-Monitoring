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
.style9 {font-size: large; color: #000000; }
.style35 {font-family: "Times New Roman", Times, serif}
.style21 {color: #687A66}
.style22 {font-size: medium;
	font-weight: bold;
}
.style22 {font-size: medium; font-weight: bold; color: #687A66; }
.style24 {color: #E1EAF1;
	font-size: 24px;
}
.style25 {font-size: medium}
.style34 {font-weight: bold; color: #00CCFF; font-size: x-large; }
.style6 {color: #0099CC}
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
          
            <h2 class="style3">Search Employee Details </h2>
            <div class="mainbar">
              <div class="article style1">
                <form id="form1" name="form1" method="post" action="SearchHealthDetails1.jsp">
                  <div align="center">
                    <table width="332" height="135" border="0">
                      <tr>
                        <td width="130" height="77"><span class="style22">Emp Id</span></td>
                        <td width="192"><label>
                          <input name="empid" type="text" id="empid" />
                        </label></td>
                      </tr>
                      <tr>
                        <td height="52" colspan="2"><div align="center">
                            <label>
                            <input type="submit" name="Submit" value="Search" />
                            </label>
                        </div></td>
                      </tr>
                    </table>
                  </div>
                  <p align="center">&nbsp;</p>
                </form>
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
