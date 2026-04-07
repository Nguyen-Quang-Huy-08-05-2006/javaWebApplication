# security_report.md

## 1. XSS là gì? Vì sao `<c:out>` an toàn hơn `${keyword}`?

XSS (Cross-Site Scripting) là lỗ hổng xảy ra khi dữ liệu người dùng được hiển thị mà không escape, khiến trình duyệt thực thi JavaScript độc hại.

Ví dụ input:
<script>alert(1)</script>

- Dùng `${keyword}`:
<h1>... <script>alert(1)</script></h1>
→ Trình duyệt chạy script → popup xuất hiện.

- Dùng `<c:out value="${keyword}"/>`:
<h1>... &lt;script&gt;alert(1)&lt;/script&gt;</h1>
→ Chỉ hiển thị text → không chạy script.

Kết luận: `<c:out>` escape HTML → chống XSS.

---

## 2. `<c:if>` vs `<c:choose>`

- `<c:if>`: dùng cho 1 điều kiện đơn  
- `<c:choose>`: giống if - else if - else, dùng khi có nhiều trường hợp loại trừ nhau  

### Trong bài này:
- “Giá vé” và “Vé còn lại” có nhiều trạng thái:
  - miễn phí / có giá  
  - hết vé / sắp hết / còn vé  

→ Nên dùng `<c:choose>` vì chỉ chọn 1 trạng thái phù hợp

Kết luận:
- Điều kiện đơn → `<c:if>`  
- Nhiều nhánh → `<c:choose>`  

---

## 3. `<c:url>` vs hardcode URL

Hardcode:
href="/events/1/book"

Nếu deploy tại `/ticketing`:
- URL đúng: /ticketing/events/1/book  
- Hardcode sẽ thành: /events/1/book → sai → 404  

Dùng JSTL:
<c:url value="/events/${event.id}/book"/>

→ Tự thêm context path:
- `/` → /events/...  
- `/ticketing` → /ticketing/events/...  

Kết luận:
`<c:url>` giúp URL luôn đúng khi đổi context path, tránh lỗi 404.
