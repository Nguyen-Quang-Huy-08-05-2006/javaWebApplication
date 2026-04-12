# BÀI 1 – PHÂN TÍCH LỖI VIEWRESOLVER

## 1. Mô tả lỗi

Trong cấu hình hiện tại, hệ thống sử dụng Thymeleaf thông qua `SpringResourceTemplateResolver` nhưng lại cấu hình:

* Prefix: `/WEB-INF/views`
* Suffix: `.jsp`

Điều này dẫn đến lỗi khi render giao diện (HTTP 500) hoặc không hiển thị đúng.

---

## 2. Nguyên nhân

* Thymeleaf chỉ hỗ trợ file `.html`
* JSP sử dụng cơ chế khác (JSP Engine của Servlet container)
* Việc dùng Thymeleaf để đọc file `.jsp` là sai về mặt công nghệ

---

## 3. Phân tích

Có sự nhầm lẫn giữa hai công nghệ View:

| Công nghệ | File    | Cách xử lý              |
| --------- | ------- | ----------------------- |
| JSP       | `.jsp`  | Servlet container xử lý |
| Thymeleaf | `.html` | Template Engine xử lý   |

Việc cấu hình Thymeleaf với `.jsp` khiến hệ thống không thể render view.

---

## 4. Cách khắc phục

Do dự án đang sử dụng JSP từ trước, giải pháp đúng là:

* Loại bỏ cấu hình Thymeleaf
* Sử dụng `InternalResourceViewResolver` cho JSP

---

## 5. Kết luận

Lỗi xảy ra do cấu hình sai ViewResolver khi trộn hai công nghệ JSP và Thymeleaf.
Giải pháp là sử dụng đúng ViewResolver tương ứng với công nghệ đang dùng.
