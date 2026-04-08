<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Menu</title>
</head>
<body>

<h2>Menu</h2>

<c:forEach var="item" items="${orders}">
    <p>${item.name} - ${item.price} VND</p>
</c:forEach>

</body>
</html>