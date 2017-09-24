<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tcs.ilp.Teamc.bean.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bck1.jpg">
<h1>Employee List</h1>
<center>
<form action="defaultHome.html">
<table border="1">
 <tr bgcolor="#33CCFF">
    <th>Empid</th><th>EMPNAME</th><th>DOB</th><th>DOJ</th><th>DIVISION</th><th>GENDER</th><th>CTC</th>
    <th>DESG</th><th>UNITHEADID</th><th>PROJECTID</th>
    
 </tr>
<%ArrayList<EmpBean> al=(ArrayList<EmpBean>) request.getAttribute("empList");
 for(EmpBean eb:al)
 {
%>
 <tr>
   <td><%=eb.getEmpid() %></td><td><%=eb.getName() %></td><td><%=eb.getDob()%></td>
    <td><%=eb.getDoj() %></td><td><%=eb.getDiv() %></td><td><%=eb.getSex() %></td>
    <td><%=eb.getCtc() %></td><td><%=eb.getDesig() %></td><td><%=eb.getUHID() %></td>
    <td><%=eb.getProjID() %></td>
   
 </tr>   
 
 <%
 }
 %>	 
 




</table>
<input type="submit" value="ok"/>
</form>
</center>
<center>
<div id="footer" style="color:green">

© 2013-2014 abc Consultancy Services Limited. All Rights Reserved

</div>
</center>


</body>
</html>