<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm sự kiện</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 24px;
            line-height: 1.5;
        }

        h1, h2, h3 {
            margin-bottom: 12px;
        }

        .summary {
            margin-bottom: 16px;
        }

        .empty-message {
            padding: 12px;
            background: #fff3cd;
            border: 1px solid #ffe69c;
            color: #856404;
            border-radius: 6px;
            margin: 16px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 16px;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
            vertical-align: middle;
        }

        th {
            background: #f5f5f5;
        }

        .badge-free {
            display: inline-block;
            padding: 4px 8px;
            background: #198754;
            color: white;
            border-radius: 12px;
            font-size: 12px;
            font-weight: bold;
        }

        .ticket-soldout {
            color: #dc3545;
            font-weight: bold;
        }

        .ticket-low {
            color: #fd7e14;
            font-weight: bold;
        }

        .ticket-ok {
            color: #198754;
            font-weight: bold;
        }

        .btn-book {
            display: inline-block;
            padding: 6px 12px;
            background: #0d6efd;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn-disabled {
            display: inline-block;
            padding: 6px 12px;
            background: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            pointer-events: none;
            cursor: not-allowed;
            opacity: 0.7;
        }

        .footer-box {
            margin-top: 20px;
            padding: 12px;
            background: #f8f9fa;
            border-radius: 6px;
        }
    </style>
</head>
<body>

<h1>Kết quả tìm kiếm cho: <c:out value="${keyword}" /></h1>

<div class="summary">
    <p>Tìm thấy <strong>${empty events ? 0 : fn:length(events)}</strong> sự kiện.</p>
</div>

<c:if test="${empty events}">
    <div class="empty-message">
        Không tìm thấy sự kiện nào phù hợp.
    </div>
</c:if>

<c:if test="${not empty events}">
    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td>${status.count}</td>

                <td>
                    <c:out value="${event.name}" />
                </td>

                <td>
                    <c:out value="${event.date}" />
                </td>

                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge-free">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true" />
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="ticket-soldout">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                                    <span class="ticket-low">
                                        Sắp hết (còn <c:out value="${event.remainingTickets}" /> vé)
                                    </span>
                        </c:when>
                        <c:otherwise>
                                    <span class="ticket-ok">
                                        <c:out value="${event.remainingTickets}" />
                                    </span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <c:url var="bookUrl" value="/events/${event.id}/book" />
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="btn-disabled">Đặt vé</span>
                        </c:when>
                        <c:otherwise>
                            <a class="btn-book" href="${bookUrl}">Đặt vé</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<div class="footer-box">
    <c:if test="${not empty events and events[0] != null and events[0].name != null}">
        <p>
            Tên sự kiện đầu tiên:
            <strong>${fn:toUpperCase(events[0].name)}</strong>
        </p>
    </c:if>

    <p>
        Số ký tự của từ khóa tìm kiếm:
        <strong>${fn:length(keyword)}</strong> ký tự
    </p>
</div>

</body>
</html>