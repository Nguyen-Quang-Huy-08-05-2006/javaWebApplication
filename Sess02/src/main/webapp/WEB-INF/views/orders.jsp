<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách đơn hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 30px;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 16px;
    }
    table, th, td {
      border: 1px solid #999;
    }
    th, td {
      padding: 10px;
      text-align: center;
    }
    .top-bar {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .counter {
      margin-top: 20px;
      font-weight: bold;
      color: darkblue;
    }
    a {
      text-decoration: none;
      color: red;
    }
  </style>
</head>
<body>

<div class="top-bar">
  <div>
    <h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>
  </div>
  <div>
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
  </div>
</div>

<table>
  <thead>
  <tr>
    <th>Mã đơn</th>
    <th>Tên sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="order" items="${requestScope.orders}">
    <tr>
      <td>${order.orderCode}</td>
      <td>${order.productName}</td>
      <td>
        <fmt:formatNumber value="${order.totalAmount}" type="number" groupingUsed="true"/> VNĐ
      </td>
      <td>
        <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<div class="counter">
  Tổng lượt xem đơn hàng toàn hệ thống: ${applicationScope.totalViewCount}
</div>

</body>
</html>