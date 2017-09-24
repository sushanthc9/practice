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
<body>
<table border="1">
<tr bgcolor="#33CCFF">
<th></th><th>Empid</th><th></th><th>EMPNAME</th><th>DOB</th><th>DOJ</th><th>DIVISION</th><th>GENDER</th><th>CTC</th>
    <th></th><th>DESG</th><th>UNITHEADID</th><th>PROJECTID</th>
    </tr>
<% ArrayList<EmpBean> al=(ArrayList<EmpBean>)request.getAttribute("emplist");
for(EmpBean eb:al)
{
%>
<form action="controller?name=addOneBgc" method="post">
<div align="center">
<tr><td><input type="checkbox" name="emp1" value=<%= eb.getEmpid()%> ></input></td>
<td><%=eb.getEmpid() %></td>
<td><input type="checkbox" name="ename" value=<%=eb.getName() %>></td>
      <td><%=eb.getName() %></td><td><%=eb.getDob()%></td>
    <td><%=eb.getDoj() %></td><td><%=eb.getDiv() %></td><td><%=eb.getSex() %></td>
    <td><%=eb.getCtc() %></td>
    <td><input type="checkbox" name="edesig" value=<%=eb.getDesig() %>></td>
    <td><%=eb.getDesig() %></td><td><%=eb.getUHID() %></td>
    <td><%=eb.getProjID() %></td>
</tr>
<%
}
%>


</div>
<div>
<input type="submit" value="add"></input>
</div>
</form>

</body>
</html>