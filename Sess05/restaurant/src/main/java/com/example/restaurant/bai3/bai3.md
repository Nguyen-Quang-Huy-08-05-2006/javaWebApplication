# BÀI 3 – MODULE CẬP NHẬT THÔNG TIN THỰC ĐƠN

## 1. Data Flow (Luồng dữ liệu)

Người dùng nhấn "Chỉnh sửa" tại danh sách món ăn (View A - dish-list.html)

↓

Trình duyệt gửi request:
`/bai3/edit/{id}`

↓

Controller nhận ID thông qua @PathVariable

↓

Controller gọi Service để tìm Dish theo ID

↓

Trường hợp:

* Nếu tìm thấy → đưa object Dish vào Model với key "dish"
* Nếu không tìm thấy → redirect về `/bai2/dishes` kèm thông báo lỗi

↓

View B (edit-dish.html) nhận object thông qua `th:object`

↓

Form sử dụng `th:field` để bind dữ liệu vào input

---

## 2. Thymeleaf Binding sử dụng

* `th:object="${dish}"` → liên kết object
* `th:field="*{name}"` → bind field name
* `th:field="*{price}"` → bind field price
* `@{/bai3/edit/{id}(id=${dish.id})}` → tạo URL động

---

## 3. Xử lý bẫy dữ liệu

Nếu ID không tồn tại:

* Controller không trả về view edit
* Redirect về `/bai2/dishes`
* Truyền thông báo lỗi:
  "Không tìm thấy món ăn yêu cầu!"

---

## 4. Kết luận

Bài này giúp:

* Hiểu Data Binding trong Thymeleaf
* Xử lý điều hướng và validate dữ liệu đầu vào
* Tạo flow thực tế giữa các trang
