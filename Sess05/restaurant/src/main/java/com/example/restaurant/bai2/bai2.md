# BÀI 2 – THIẾT KẾ TRANG DANH SÁCH MÓN ĂN ĐỘNG

## 1. Cấu trúc đối tượng Dish

Dish gồm các thuộc tính:

* id: Long
* name: String
* price: double
* isAvailable: boolean

---

## 2. Data Flow (I/O)

Client truy cập:
`/bai2/dishes`

↓

Controller gọi Service

↓

Service trả về List<Dish>

↓

Controller đưa vào Model:

* key: "dishes"

↓

View: dish-list.html

↓

Thymeleaf render:

* Lặp danh sách
* Hiển thị trạng thái còn/hết hàng
* Đổi màu nếu hết hàng

---

## 3. Xử lý hiển thị

* Sử dụng `th:each` để lặp danh sách
* Dùng `th:if` / `th:unless` để hiển thị trạng thái:

    * true → "Còn hàng"
    * false → "Hết hàng" (màu đỏ)

---

## 4. Bẫy dữ liệu

Nếu danh sách null hoặc empty:

Hiển thị:
"Hiện tại nhà hàng đang cập nhật thực đơn, vui lòng quay lại sau"

---

## 5. Kết luận

Thymeleaf giúp:

* Render dữ liệu động từ backend
* Xử lý logic hiển thị trực tiếp trên HTML
* Tăng tính trực quan và linh hoạt cho UI
