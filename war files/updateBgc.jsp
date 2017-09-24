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

<script type="text/javascript">
	function fnstats(obj)
	{

		alert('selected value '+obj.value);
		
		}

</script>
</head>
<body>
<table border="1">
<tr>
<th></th><th>Empid</th><th>Bgc_NAME</th><th>emp_desig</th><th>Bgc_admin_Status</th>
    
    </tr>
<% ArrayList<AdminBean> al=(ArrayList<AdminBean>)session.getAttribute("emplist");

for(int index=0;index<al.size();index++)
{
	AdminBean eb = (AdminBean)al.get(index);
%>
<form action="controller?name=updateBgcAdmins" method="post">
<div align="center">
<tr><td><input type="checkbox" name="emp1<%=index%>" value=<%= eb.getAdminId()%> ></input></td>
<td><%=eb.getAdminId() %></td>

      <td><%=eb.getAdminName() %></td><td><%=eb.getAdminDesig()%></td>
      <%String stat = eb.getStatus(); 
    System.out.println(stat);%>
    
    <td><select name ="stats<%=index%>" onchange="fnstats(this)">
  
  <option value="Pending" <%= "Pending".equalsIgnoreCase(stat)? "selected":""  %> >Pending</option>
  <option value="Approved" <%= "Approved".equalsIgnoreCase(stat)? "selected":"" %> >Approve</option>
  <option value="Rejected" <%= "Rejected".equalsIgnoreCase(stat)? "selected":"" %> >Reject</option>
 
</select></td>
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