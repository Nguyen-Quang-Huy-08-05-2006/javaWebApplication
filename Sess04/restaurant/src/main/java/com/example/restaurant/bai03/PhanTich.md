# BÀI 3 – LỰA CHỌN CÁCH TRUYỀN THAM SỐ TRÊN URL

## 1. Phân tích

### Cách A:

URL: `/bai3/orders/5`

* Số 5 nằm trong **URI Path (đường dẫn)**.
* Đây là một phần của tài nguyên (resource).
* Mang ý nghĩa: truy cập trực tiếp vào đơn hàng có ID = 5.

---

### Cách B:

URL: `/bai3/orders?id=5`

* Số 5 nằm trong **Query String (chuỗi truy vấn)**.
* Dạng key-value (`id=5`).
* Thường dùng để lọc, tìm kiếm hoặc phân trang.

---

## 2. So sánh

| Tiêu chí | PathVariable      | RequestParam   |
| -------- | ----------------- | -------------- |
| Vị trí   | URI Path          | Query String   |
| Ý nghĩa  | Tài nguyên cụ thể | Điều kiện lọc  |
| RESTful  | Phù hợp           | Ít phù hợp hơn |

---

## 3. Kết luận

Để lấy thông tin của một đối tượng cụ thể theo ID, nên sử dụng **Cách A (PathVariable)** vì:

* Tuân theo chuẩn RESTful
* URL rõ ràng, dễ hiểu
* Phản ánh đúng bản chất tài nguyên

---

## 4. Ví dụ kết quả

Khi truy cập:

`/bai3/orders/5`

Hệ thống sẽ trả về:

`Chi tiết đơn hàng số 5`
