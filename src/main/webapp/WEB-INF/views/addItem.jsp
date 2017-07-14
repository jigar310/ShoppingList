<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Add Item to Shopping List</title>
</head>
<body>
	<h3>Enter The Shopping Item</h3>
	<div style="color:${cssColor}">${msg}</div>
	<form:form method="POST" action="saveOrUpdateItem"
		modelAttribute="shoppingItemForm">
		<table>
		<form:hidden path="id" />
		<form:hidden path="bought" value="false" />
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="note">Note</form:label></td>
				<td><form:textarea path="note" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
	<a href="<c:url value='/listAllItems' />" >View/Modify Shopping List</a>
</body>
</html>