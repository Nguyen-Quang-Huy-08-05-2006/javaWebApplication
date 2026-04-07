# Phân tích Scope và Race Condition

Thông báo lỗi đăng nhập nên lưu ở **Request Scope** vì chỉ cần hiển thị trong một lần request khi người dùng nhập sai. Nếu lưu ở **Session Scope**, lỗi có thể còn tồn tại ở các lần truy cập sau dù người dùng đã đăng nhập đúng.

Biến `totalViewCount` phải lưu ở **Application Scope** vì đây là dữ liệu dùng chung cho toàn bộ hệ thống. Nếu lưu ở **Session Scope**, mỗi nhân viên sẽ thấy một bộ đếm riêng, không phản ánh tổng lượt xem thật.

Race Condition là tình huống nhiều request cùng lúc cập nhật một biến dùng chung làm kết quả bị sai. Với đoạn code:

```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);