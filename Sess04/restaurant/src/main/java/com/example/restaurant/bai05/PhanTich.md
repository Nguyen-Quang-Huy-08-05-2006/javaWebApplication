# BÀI 5 – QUẢN LÝ ĐƠN HÀNG TOÀN DIỆN

## 1. Kiến trúc 3 tầng (Data Flow)

Client (Browser/Postman)
↓
Controller (OrderController)
↓
Service (OrderService)
↓
Repository (OrderRepository)
↓
Dữ liệu (List đơn hàng)

---

## 2. Bẫy dữ liệu ép kiểu

Khi sử dụng @PathVariable Long id, nếu người dùng nhập sai (ví dụ: /orders/t), Spring sẽ không ép kiểu được từ String sang Long và ném ra lỗi 400 (TypeMismatchException).

Cách xử lý:
Sử dụng @ExceptionHandler để bắt lỗi và trả về thông báo thân thiện thay vì crash hệ thống.

---

## 3. Tính Idempotent

* DELETE là idempotent:
  Gọi 1 lần hay nhiều lần đều cho cùng kết quả (đơn hàng bị xóa).
  → Không gây lỗi dữ liệu.

* POST không idempotent:
  Gọi nhiều lần sẽ tạo nhiều đơn hàng.
  → Dễ sinh dữ liệu rác khi mạng lag hoặc user spam.

---

## 4. Kết luận

Cần thiết kế API đúng chuẩn:

* GET → đọc dữ liệu
* POST → tạo dữ liệu (cần kiểm soát)
* DELETE → an toàn khi gọi nhiều lần

Đồng thời phải xử lý ngoại lệ để đảm bảo hệ thống ổn định và thân thiện với người dùng.
