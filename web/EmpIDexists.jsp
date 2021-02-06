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
.style8 {	color: #FF0000;
	font-size: large;
	font-weight: bold;
}
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
          
            <h2 class="style3">Add Employee </h2>
            <form name="form1" method="post" action="AddEmp">
              <p><span class="style8">Employee ID already Exists .... </span></p>
              <table width="383" height="373" border="0">
                <tr>
                  <td><div align="right" class="style9">
                      <div align="left">Employee ID </div>
                  </div></td>
                  <td><label>
                    <input name="empid" type="text" id="empid" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td width="175"><div align="right" class="style9">
                      <div align="left">Employee Password </div>
                  </div></td>
                  <td width="198"><label>
                    <input name="password" type="password" id="password" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td><div align="right" class="style9">
                      <div align="left">Employee Name </div>
                  </div></td>
                  <td><label>
                    <input name="empname" type="text" id="empname" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td><div align="right" class="style9">
                      <div align="left">Employee Position </div>
                  </div></td>
                  <td><label>
                    <input name="empposition" type="text" id="empposition" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td><div align="right" class="style9">
                      <div align="left">Employee Department</div>
                  </div></td>
                  <td><label>
                    <input name="empdept" type="text" id="empdept" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td><div align="right" class="style9">
                      <div align="left">Email-Id</div>
                  </div></td>
                  <td><label>
                    <input name="emailid" type="text" id="emailid" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td><div align="right" class="style9">
                      <div align="left">Mobile Number </div>
                  </div></td>
                  <td><label>
                    <input name="mobileno" type="text" id="mobileno" />
                    </label>                  </td>
                </tr>
                <tr>
                  <td colspan="2"><div align="center">
                      <label>
                      <input type="submit" name="Submit" value="ADD" />
                      <a href="success.jsp"></a></label>
                  </div></td>
                </tr>
                <tr>
                  <td colspan="2"><div align="center"><a href="ViewEmployee.jsp" class="style2">View / Delete  Employee </a></div></td>
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
