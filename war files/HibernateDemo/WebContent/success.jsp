<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th> StudentName </th>
<th> StudentId</th>
<th>StudentAge</th>
<th>Contact no</th>
</tr>
	<s:iterator value="stuList">
		<tr>
		<td><s:property value="student_name"/></td>
		<td><s:property value="student_id"/></td>
		<td><s:property value="age"/></td>
		<td><s:property value="ContactNo"/></td>
		</tr>
	</s:iterator>
</table>
</body>
</html>