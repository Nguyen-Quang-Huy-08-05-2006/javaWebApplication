Lỗi 1: getServletMappings() dùng "/api/*" nên DispatcherServlet chỉ xử lý URL bắt đầu bằng /api/. Vì vậy /welcome không được Spring MVC xử lý, dẫn tới 404.

Lỗi 2: @ComponentScan(basePackages = "com.demo.service") quét sai package, nên Spring không tìm thấy WelcomeController trong com.demo.controller.

Nếu chỉ sửa lỗi 1: request vào được Spring MVC nhưng vẫn không có controller xử lý /welcome, nên ứng dụng vẫn không chạy đúng.
Cách sửa đúng:
đổi servlet mapping thành "/"
đổi component scan sang package chứa controller, ví dụ "com.demo.controller"