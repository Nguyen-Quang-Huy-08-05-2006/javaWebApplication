<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div>
    <a href="<c:url value='/employees'/>">Danh sách nhân viên</a> |
    Xin chào <c:out value="${sessionScope.loggedUser}"/> |
    <a href="<c:url value='/logout'/>">Đăng xuất</a>

    <c:if test="${sessionScope.role == 'hr_manager'}">
        | Manager
    </c:if>
</div>
<hr>