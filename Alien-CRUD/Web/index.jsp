<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alien CRUD - Index</title>
</head>
<body>
<p>This is a demo application dealing with CRUD operations</p>

<%@ include file="/add-alien.jsp"%>
<s:action name="getAliens" executeResult="true"/>
</body>
</html>