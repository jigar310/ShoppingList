<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Add Item to Shopping List</title>
<script>
	function deleteItem(url){
		var r = confirm("Are you sure you want to delete?");
		if (r == true) {
			window.location.href = url;
		} else {
		    return false;
		}
	}
</script>
</head>
<body>
	<h3>Modify The Shopping Item</h3>
	<div style="color:${cssColor}">${msg}</div>
	<form:form method="POST" action="../saveOrUpdateItem"
		modelAttribute="shoppingItemForm">
		<table>
		<form:hidden path="id" value="${shoppingItemForm.id}" />
			<tr>
				<td><form:label path="title">Title</form:label></td>
				<td><form:input path="title" value="${shoppingItemForm.title}"/></td>
			</tr>
			<tr>
				<td><form:label path="note">Note</form:label></td>
				<td><form:textarea path="note" rows="5" cols="30" value="${shoppingItemForm.note}"/></td>
			</tr>
			<tr>
				<td><form:label path="bought">Purchased?</form:label></td>
				<td><form:checkbox  path="bought" value="${shoppingItemForm.bought}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modify" /></td> <td><input type="button" value="Delete" onclick="deleteItem('<c:url value='/deleteItem/${shoppingItemForm.id}'/>')"/></td>
			</tr>
		</table>
	</form:form>
	
	<a href="<c:url value="/addItemForm" />" >Add Item to List</a><br/>
 <a href="<c:url value="/listAllItems" />" >View/Modify Shopping List</a>
</body>
</html>