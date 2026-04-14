# BÀI 1: MODULE CẬP NHẬT THÔNG TIN NHÀ HÀNG

---

## 1. Phân tích lỗi Data Binding

### 1.1. Lỗi Tên cửa hàng bị null

#### Nguyên nhân:
Spring MVC sử dụng cơ chế Data Binding để ánh xạ dữ liệu từ form HTML vào object dựa trên nguyên tắc:

> Tên thuộc tính trong form (name) phải trùng với tên field trong object

#### Code hiện tại:

- Trong Model:
  name

- Trong HTML:
  name="restaurantName"

#### Vấn đề:
- "restaurantName" ≠ "name"
- Spring không tìm được field tương ứng
  → Không binding được dữ liệu
  → Giá trị `name` trong object = null

---

### 1.2. Lỗi checkbox `active` không hoạt động đúng

#### Cơ chế hoạt động của checkbox:

- Nếu KHÔNG tick → không gửi dữ liệu lên server
- Nếu tick → gửi giá trị:
  active = "MỞ_CỬA"

---

#### Vấn đề 1: Sai kiểu dữ liệu

- Backend:
  boolean active

- Frontend gửi:
  "MỞ_CỬA"

→ Spring không thể convert "MỞ_CỬA" → boolean  
→ Gây lỗi hoặc sai dữ liệu

---

#### Vấn đề 2: Trường hợp không tick

- Không có param `active`
- Với kiểu boolean primitive → mặc định = false

→ Logic dễ bị sai nếu không kiểm soát rõ

---

## 2. Kết luận

| Lỗi | Nguyên nhân |
|-----|------------|
| name = null | Sai name attribute |
| active sai | value không phải boolean + checkbox không gửi khi không tick |

---

## 3. Hướng khắc phục

- Đặt đúng `name` theo field trong model
- Checkbox phải dùng giá trị boolean (true/false)
- Nên dùng hidden field để đảm bảo luôn có giá trị gửi lên

---

## 4. Best Practice

- Sử dụng Thymeleaf (`th:field`) để đảm bảo binding chính xác
- Tránh hard-code name trong HTML
- Đảm bảo dữ liệu gửi lên đúng kiểu với backend