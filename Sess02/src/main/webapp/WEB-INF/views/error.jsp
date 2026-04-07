<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<body>
<h2>Lỗi</h2>
<p style="color:red;"><c:out value="${errorMessage}"/></p>
<a href="<c:url value='/employees'/>">Quay lại</a>
</body>
</html>