# BÀI 5 – SMART ORDER SYSTEM

## 1. Kiến trúc 3 tầng (Data Flow)

User truy cập: `/bai5/order`

↓

OrderController nhận request

↓

Gọi OrderService xử lý logic:

* Lấy danh sách món
* Tính tổng tiền

↓

OrderService gọi OrderRepository:

* Trả về dữ liệu in-memory

↓

Controller đưa dữ liệu vào Model:

* dishes
* totalPrice

↓

View (HTML) hiển thị

---

## 2. Natural Templating

HTML vẫn chạy độc lập khi mở bằng trình duyệt:

* Có sẵn dữ liệu mẫu (mock data)
* Khi chạy server → Thymeleaf override bằng `${...}`

---

## 3. Bảo mật /WEB-INF/

Người dùng truy cập:
`/WEB-INF/templates/order.html`

👉 sẽ bị chặn vì:

* `/WEB-INF/` không public
* Tomcat không cho truy cập trực tiếp
* Chỉ ViewResolver mới truy cập được

---

## 4. Dumb View

HTML KHÔNG được:

* tính tổng tiền
* xử lý logic

👉 tất cả xử lý nằm ở Service

---

## 5. Kết luận

* Tách rõ trách nhiệm (Controller - Service - Repo)
* UI chỉ hiển thị
* Logic nằm backend
