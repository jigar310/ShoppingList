<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Shopping List</title>
    <style type="text/css">
    table{
    border: 1px solid black;
    table-layout: fixed;
    border-collapse: collapse;
    
}
th {
    background-color: #4CAF50;
    color: white;
}
th, td {
    border: 1px solid black;
    width: 100px;
    text-align: center;
    font-family: "Times New Roman", Georgia, Serif;
}
    </style>
</head>
<body>

<H2>Shopping List</H2>
    
  <div style="color:${cssColor}">${msg}</div>
  <c:if test="${not empty items}">
<div style="overflow-x:auto;">
		<table>
			<tr><th>Item</th><th>Purchased?</th><th>View/Modify</th></tr>
			<c:forEach var="item" items="${items}">
				<tr <c:if test="${item.bought}">bgcolor="#9B9B9B"</c:if>><td>${item.title}</td> <td><input type="checkbox" disabled <c:if test="${item.bought}">checked</c:if>/></td><td> <a href="<c:url value="/viewItem/${item.id}" />" >Modify</a></td></tr>
			</c:forEach>
		</table>
</div>
	</c:if>
 
 <a href="<c:url value="/addItemForm" />" >Add Item to List</a><br/>
</body>
</html>