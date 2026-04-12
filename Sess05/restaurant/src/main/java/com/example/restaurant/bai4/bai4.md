# BÀI 4 – TỐI ƯU HÓA GIAO DIỆN (DRY)

## 1. So sánh 2 cách tiếp cận

| Tiêu chí                    | Cách A: Copy-Paste | Cách B: Layout Dialect |
| --------------------------- | ---------------- | ------------------- |
| Tốc độ ban đầu              | Nhanh            | Chậm hơn            |
| Tái sử dụng                 |  Kém             |  Cao                |
| Bảo trì                     |  Rất khó         |  Dễ                 |
| DRY (Don't Repeat Yourself) |  Vi phạm         |  Tuân thủ           |
| Khi sửa Header/Footer       | Phải sửa nhiều file | Sửa 1 nơi           |
| Độ chuyên nghiệp            | Thấp             | Cao                 |

---

## 2. Kết luận lựa chọn

Chọn **Cách B (Layout Dialect)** vì:

* Tránh lặp code
* Dễ bảo trì
* Chuẩn thực tế production

---

## 3. Cách hoạt động (Data Flow UI)

User request → Controller → View con (child view)

↓

View con dùng:
`layout:decorate="layout/main-layout"`

↓

Thymeleaf:

* Load layout chính
* Inject nội dung view con vào fragment

↓

Render HTML hoàn chỉnh

---

## 4. Vì sao phải đăng ký LayoutDialect?

Thymeleaf mặc định **KHÔNG hiểu**:

```html
layout:decorate
layout:fragment
```

👉 Đây là extension từ thư viện:

```
thymeleaf-layout-dialect
```

---

Nếu không đăng ký:

```java
engine.addDialect(new LayoutDialect());
```

👉 sẽ lỗi:

* Không nhận layout
* Không render fragment

---

## 5. Kết luận kỹ thuật

Layout Dialect giúp:

* Tách layout và content
* Giữ code sạch
* Áp dụng chuẩn DRY

Nhưng:

* Phải config thêm trong SpringTemplateEngine
