<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<meta charset="UTF-8">
<title>Edit Alien</title>
<s:head/>
</head>
<body>
<p><a href="index.jsp">Home</a></p>
<s:form action="editAlien" method="post">
<s:textfield key="alien.alienId" label="Enter Alien Id" readonly = "true">
</s:textfield>

<s:textfield key="alien.alienName" label="Enter Alien Name">
</s:textfield>

<s:textfield key="alien.planetName" label="Enter Planet Name">
</s:textfield>
<s:submit value="Edit Alien"></s:submit>
</s:form>

</body>
</html>