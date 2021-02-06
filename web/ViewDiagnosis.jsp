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
.style4 {font-size: large}
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
              <td><div align="center"><a href="ChatBot.jsp" class="style2">Chat Bot  </a></div></td>
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
          
            <h2 class="style3">View Diagnosis </h2>
            <p>&nbsp;</p>
            <form name="form1" method="post" action="ViewDiagnosis1.jsp">
              <table width="376" height="133" border="0">
                <tr>
                  <td width="167"><span class="style4">Disease</span></td>
                  <td width="199"><label>
                    <input name="disease" type="text" id="disease">
                  </label></td>
                </tr>
                <tr>
                  <td colspan="2"><div align="center">
                    <label>
                    <input type="submit" name="Submit" value="View">
                    </label>
                  </div></td>
                </tr>
              </table>
                        </form>
            <p>&nbsp;</p>
        </div></td>
      </tr>
      <tr>
        <td height="74" colspan="2" bgcolor="#006666">&nbsp;</td>
      </tr>
    </table>
    </body>
</html>
