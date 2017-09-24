<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BGC Test Schedule</title>
<center>
<h1 style="color:#1919FF;">Create BgcTestSchedule</h1>
<style>span{color:red;}</style>
<script type="text/javascript">	
	function disp1()
	{
		var spanobj01=document.getElementById("errspan01");
		spanobj01.innerHTML="";
	}
	function disp2()
	{
		var spanobj02=document.getElementById("errspan02");
		spanobj02.innerHTML="";
	}
	function disp3()
	{
		var spanobj03=document.getElementById("errspan03");
		spanobj03.innerHTML="";
	}
	function validate1()
	{
		if (document.demo.eid.value=="")
		{
			var spanobj01=document.getElementById("errspan01");
			spanobj01.innerHTML="Enter employee id";
			return false;
			
     			
		}
		if ((document.demo.eid.value < 1000) || (document.demo.eid.value > 9999999))
		{
			var spanobj01=document.getElementById("errspan01");
			spanobj01.innerHTML="Enter correct Employee ID";
			return false;
		}
		if (document.demo.bgcadmid.value == "")
		{
			var spanobj02=document.getElementById("errspan02");
			spanobj02.innerHTML="Enter BGC Admin ID";
			return false;
		}
		if ((document.demo.bgcadmid.value < 1000) || (document.demo.bgcadmid.value > 9999999))
		{
			var spanobj02=document.getElementById("errspan02");
			spanobj02.innerHTML="Enter correct BGC Admin ID";
			return false;
		}
		if ((document.demo.bgcadmid.value.length < 4 )|| (document.demo.bgcadmid.value.length > 8))
		{
			var spanobj02=document.getElementById("errspan02");
			spanobj02.innerHTML="Enter correct length";
			return false;
		}
		
	return true;
	}
	function ValidateAlpha(evt)
        {
            var keyCode = (evt.which) ? evt.which : evt.keyCode
            if (((keyCode < 65 )|| (keyCode > 90)) && ((keyCode < 97) || (keyCode > 123)) && (keyCode != 32))
		{
			alert("Enter Alphabets"); 
        		    return false;
		}
                return true;
        }            
	function isNumberKey(evt)
    	{
          	var charCode = (evt.which) ? evt.which : event.keyCode
	     if((charCode > 31) && (charCode < 48) || (charCode > 57))
	    {
		alert("Enter Numbers Only!");
		return false;
	    }
	return true;
}
</script>
</head>
<body background="bck1.jpg">
<script type="text/javascript" src="validate.js">
</script>
<form name="demo" action="controller?name=createBgcSch" method="post" onsubmit="return validate_form()" ><br><br><br>
<pre><br> EmployeeId::                 <input type="text" name="eid" onkeypress="return isNumberKey(event)" onFocus="disp1()" /></pre><span id="errspan01"></span>



<pre><br>BgcTestAdminId::                         <select name="bgcadmid"></pre>
 <% 
 try{
	
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.192.71:1521:javadb","H70ORAUSER3D","tcshyd");
 Statement st=con.createStatement();
 String sql="select * from Bgcadmin1 where status='Approved'";
 ResultSet rs=st.executeQuery(sql);
 while(rs.next()){
%>
  <option value="<%=rs.getInt(1)%>" > <%=rs.getInt(1)%> </option>
<% System.out.println("$$$$");%>

 <%   }    
   
   %>   
            
  <% 
  }catch(Exception e){
  }     
 %>
 </select>

<pre><br>Start_Date(DD-MON-YY)::                  <input type="text" name="sdate"/></pre>

<pre><br>End_Date(DD-MON-YY)::                    <input type="text" name="edate"/></pre>

 	
<br><input type="submit"  value="Submit" onClick="return validate1()"/>

</center>
</form>
<center>
<div id="footer" style="color:green">

© 2013-2014 abc Consultancy Services Limited. All Rights Reserved

</div>
</center>
</body>
</html>
