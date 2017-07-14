<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC Java Configuration Example</title>
</head>
<body>

<H2>Welcome to Shopping List</H2>
    
 <a href="<c:url value="/addItemForm" />" >Add Item to List</a><br/>
 <a href="<c:url value="/listAllItems" />" >View/Modify Shopping List</a>
</body>
</html>