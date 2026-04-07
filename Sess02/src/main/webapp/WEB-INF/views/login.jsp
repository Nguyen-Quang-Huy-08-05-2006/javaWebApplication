<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${not empty error}">
    <p style="color:red;"><c:out value="${error}"/></p>
</c:if>

<form action="<c:url value='/login'/>" method="post">
    <div>
        Username: <input type="text" name="username">
    </div>
    <div>
        Password: <input type="password" name="password">
    </div>
    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>