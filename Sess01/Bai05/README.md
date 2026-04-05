# Bài 5: Khởi tạo Bean bằng Annotation (Cyber Center)

## 📋 Mục tiêu

- Hiểu cách sử dụng các Annotation cơ bản: `@Component`, `@Value`, `@ComponentScan`
- Thực hành cấu hình Bean trực tiếp trên lớp Java mà không cần file XML
- Sử dụng `AnnotationConfigApplicationContext` để khởi tạo Container

## 📁 Cấu trúc Folder

```
Bai05/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/example/
│       │       ├── config/
│       │       │   └── AppConfig.java      (File cấu hình quét Bean)
│       │       ├── model/
│       │       │   └── SystemConfig.java   (Lớp định nghĩa Bean)
│       │       └── Main.java               (Hàm chạy chính)
│       └── resources/                      (Thư mục trống)
├── build.gradle                            (Cấu hình Gradle với Spring dependencies)
└── README.md                               (File hướng dẫn này)
```

## 📝 Chi tiết các file

### 1. **AppConfig.java** (Configuration Class)

```java
@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // Đây adalah "đầu não" điều khiển việc tìm kiếm Bean
}
```

**Chức năng:**

- `@Configuration`: Đánh dấu đây là lớp cấu hình Spring
- `@ComponentScan("org.example")`: Quét toàn bộ các lớp có `@Component` trong package `org.example`

### 2. **SystemConfig.java** (Model Bean)

```java
@Component
public class SystemConfig {

    @Value("Cyber Center - Chi nhánh Hồ Chí Minh")
    private String branchName;

    @Value("08:00 AM")
    private String openingHour;

    // Getters & Setters...
}
```

**Chức năng:**

- `@Component`: Đăng ký lớp này là một Bean của Spring Container
- `@Value`: Gán giá trị khởi tạo trực tiếp cho biến thành viên
- Spring sẽ tự động khởi tạo instance và tiêm giá trị

### 3. **Main.java** (Entry Point)

```java
public static void main(String[] args) {
    // Khởi tạo Container với lớp cấu hình Java (không dùng XML)
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Lấy Bean từ Container
    SystemConfig config = context.getBean(SystemConfig.class);

    // In kết quả
    System.out.println("Tên chi nhánh: " + config.getBranchName());
    System.out.println("Giờ mở cửa: " + config.getOpeningHour());
}
```

## 🚀 Cách chạy chương trình

### Phương pháp 1: Sử dụng Gradle (Khuyên dùng)

```bash
# Trong folder Bai05
gradle build
gradle run
```

### Phương pháp 2: Sử dụng IntelliJ IDEA

1. Mở project này trong IntelliJ
2. Nhấn chuột phải vào `Main.java`
3. Chọn "Run 'Main.main()'"

### Phương pháp 3: Compile & Run thủ công

```bash
javac -d bin src/main/java/org/example/config/AppConfig.java
javac -d bin src/main/java/org/example/model/SystemConfig.java
javac -d bin src/main/java/org/example/Main.java
java -cp bin org.example.Main
```

## ✅ Kết quả mong đợi

```
=== Thông Tin Cấu Hình Hệ Thống ===
Tên chi nhánh: Cyber Center - Chi nhánh Hồ Chí Minh
Giờ mở cửa: 08:00 AM

Toàn bộ thông tin: SystemConfig{branchName='Cyber Center - Chi nhánh Hồ Chí Minh', openingHour='08:00 AM'}
```

## 🔑 Các Annotation quan trọng

| Annotation       | Chức năng                                     |
| ---------------- | --------------------------------------------- |
| `@Configuration` | Đánh dấu lớp là cấu hình Spring               |
| `@ComponentScan` | Quét package để tìm những lớp có `@Component` |
| `@Component`     | Đánh dấu lớp là một Bean                      |
| `@Value`         | Tiêm giá trị vào biến thành viên              |
| `@Autowired`     | Tiêm dependency (sẽ học sau)                  |

## 📚 Các khái niệm chính

### AnnotationConfigApplicationContext

- Thay thế cho `ClassPathXmlApplicationContext`
- Nhận lớp cấu hình Java thay vì file XML
- Tự động quét và khởi tạo các Bean

### Bean Lifecycle

1. **Scanning**: Spring quét các lớp có `@Component`
2. **Instantiation**: Tạo instance của lớp
3. **Injection**: Tiêm giá trị `@Value` vào biến
4. **Ready**: Bean sẵn sàng sử dụng

## 💡 Lợi ích của Annotation so với XML

| XML                         | Annotation                  |
| --------------------------- | --------------------------- |
| Cấu hình tập trung          | Cấu hình phân tán, gần code |
| Phải viết nhiều dòng        | Code ngắn gọn, dễ đọc       |
| Khó bảo trì                 | Dễ dàng maintain            |
| Compile time không kiểm tra | Compile time kiểm tra       |

## 🎯 Bài tập mở rộng

1. **Thêm nhiều Bean**: Tạo `ManagerConfig.java` hay `DatabaseConfig.java` với các Annotation khác nhau
2. **Sử dụng @Autowired**: Tiêm dependency vào `Main.java`
3. **Profile-based Configuration**: Tạo cấu hình khác nhau cho development/production
4. **Sử dụng Properties File**: Load giá trị từ file `.properties` thay vì hardcode

## 📖 Tài liệu tham khảo

- Spring Framework Official Documentation: https://spring.io/projects/spring-framework
- Spring Bean Documentation: https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans
