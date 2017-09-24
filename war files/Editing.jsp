<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.tcs.ilp.Teamc.bean.*" %>
<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit CTC and Designation</title>
<script type="text/javascript">

function disp4()
{
	var spanobj04=document.getElementById("errspan04");
	spanobj04.innerHTML="";
}
function disp5()
{
	var spanobj05=document.getElementById("errspan05");
	spanobj05.innerHTML="";
}


function validate1()
	{
if (document.demo.ctc.value == "" )
		{
			var spanobj04=document.getElementById("errspan04");
			spanobj04.innerHTML="Enter employee ctc";
			return false;
			
     			
		}
		if (document.demo.ctc.value < 150000 || document.demo.ctc.value > 350000 )
		{
			var spanobj04=document.getElementById("errspan04");
			spanobj04.innerHTML="incorrect ctc";
			return false;
			
     			
		}
		if (document.demo.desig.value == ""  )
		{
			var spanobj05=document.getElementById("errspan05");
			spanobj05.innerHTML="Enter employee designation";
			return false;
			
     			
		}
		return true;
		}
function ValidateAlpha(evt)
        {
            var keyCode = (evt.which) ? evt.which : evt.keyCode
            if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32 && keyCode != 13)
		{
			alert("Enter Alphabets"); 
        		    return false;
		}
                return true;
        }       
	function isNumberKey(evt)
    	{
          	var charCode = (evt.which) ? evt.which : event.keyCode
	     if((charCode > 31 && (charCode < 48 || charCode > 57)))
	    {
		alert("Enter Numbers Only!");
		return false;
	    }
	return true;
}
 
 
 
</script> 	
</head>
<body>
<h1>Edit CTC and Designation</h1>
<form action="controller?name=editingEmp" method="post">
<%EmpBean eb=(EmpBean)request.getAttribute("empdtls"); %>
<table>
<tr><td>empid</td>
	<td><input type="text" name="eid" readonly value=<%=eb.getEmpid() %>></input></td>

</tr>
<tr><td>ename</td>
	<td><input type="text" name="ename" readonly value=<%=eb.getName() %>></input></td>

</tr>
<tr><td>dob</td>
	<td><input type="text" name="edob" readonly value=<%=eb.getDob() %>></input></td>

</tr>

<tr><td>doj</td>
	<td><input type="text" name="edoj" readonly value=<%=eb.getDoj() %>></input></td>

</tr>

<tr><td>division</td>
	<td><input type="text" name="ediv" readonly value=<%=eb.getDiv() %>></input></td>

</tr>

<tr><td>sex</td>
	<td><input type="text" name="esex" readonly value=<%=eb.getSex() %>></input></td>

</tr>

<tr><td>ctc</td>
	<td><input type="text" name="ectc" value=<%=eb.getCtc() %> onkeypress="return isNumberKey(event)" onFocus="disp4()"/><br></pre><span id="errspan04"></span></input></td>

</tr>


<tr><td>desig</td>
	<td><input type="text" name="edesig" value=<%=eb.getDesig() %> onkeypress="return ValidateAlpha(event)"onFocus="disp5()"/><br></pre><span id="errspan05"></span></input></td>

</tr>

<tr><td>uhid</td>
	<td><input type="text" name="euhid" value=<%=eb.getUHID() %>></input></td>

</tr>
<tr><td>projid</td>
	<td><input type="text" name="eprojid" value=<%=eb.getProjID() %>></input></td>

</tr>


</table>

<div>

<input type="submit" value="edit"></input>
</div>
</form>
<center>
<div id="footer" style="color:green">

© 2013-2014 abc Consultancy Services Limited. All Rights Reserved

</div>
</center>
</body>
</html>