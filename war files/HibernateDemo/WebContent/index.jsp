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
<s:form action="add">
<s:textfield label="Name" key="student_name"></s:textfield>
<s:textfield label="StudentId" key="student_id"></s:textfield>
<s:textfield label="Age" key="age"></s:textfield>
<s:textfield label="ContactNo" key="ContactNo"></s:textfield>
<s:submit name="submit" value="AddCandidate"></s:submit>
</s:form>
</body>
</html>