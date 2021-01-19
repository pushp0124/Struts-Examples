<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table.alien-table td, th  {
 border : 1px solid black;
 align : center;
}
</style>
<meta charset="UTF-8">
<title>All Aliens</title>

</head>
<body>

	<p>All Aliens : </p>
	


	<table style="width:40%; " class="alien-table" >

		<tr>
			<th>Alien Id</th>
			<th>Alien Name</th>
			<th>Planet Name</th>
			<th>Actions</th>
		</tr>
		<s:iterator value="allAliens" var="alien">

			<tr>
				<td><s:property value="alienId" /></td>
				<td><s:property value="alienName" /></td>
				<td><s:property value="planetName" /></td>
				<td><s:url action="showForm" var="editAlienLink">
						<s:param name="alien.alienId" value="alienId"></s:param>
						<s:param name="alien.alienName" value="alienName"></s:param>
						<s:param name="alien.planetName" value="planetName"></s:param>
					</s:url> <a href="${editAlienLink}"> Edit</a>
				<s:url action="deleteAlien" var="deleteAlienLink">
						<s:param name="alien.alienId" value="alienId"></s:param>
						<s:param name="alien.alienName" value="alienName"></s:param>
						<s:param name="alien.planetName" value="planetName"></s:param>
					</s:url> <a href="${deleteAlienLink}"> Delete</a></td>

			</tr>

		</s:iterator>
	</table>


</body>
</html>