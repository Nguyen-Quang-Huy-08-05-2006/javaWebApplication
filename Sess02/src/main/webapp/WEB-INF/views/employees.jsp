<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<body>
<%@ include file="header.jsp" %>

<h2>Danh sách nhân viên</h2>
<table border="1">
    <tr>
        <th>STT</th><th>Mã</th><th>Họ tên</th><th>Phòng ban</th>
        <th>Lương</th><th>Ngày vào làm</th><th>Trạng thái</th><th>Chi tiết</th>
    </tr>
    <c:forEach var="emp" items="${employees}" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td><c:out value="${emp.code}"/></td>
            <td><c:out value="${emp.fullName}"/></td>
            <td><c:out value="${emp.department}"/></td>
            <td><fmt:formatNumber value="${emp.salary}" type="number" groupingUsed="true"/> VNĐ</td>
            <td><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/></td>
            <td><c:out value="${emp.status}"/></td>
            <td><a href="<c:url value='/employees/${emp.code}'/>">Xem chi tiết</a></td>
        </tr>
    </c:forEach>
</table>

<p>
    Tổng lương phòng ban Kỹ thuật:
    <fmt:formatNumber value="${technicalTotalSalary}" type="number" groupingUsed="true"/> VNĐ
</p>

<%@ include file="footer.jsp" %>
</body>
</html>