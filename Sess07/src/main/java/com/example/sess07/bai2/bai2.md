# BÀI 2: TỐI ƯU HÓA FORM DROPDOWN VỚI @ModelAttribute

---

## 1. Vấn đề trong mã nguồn hiện tại

Trong 3 API:

- showAddForm()
- showEditForm()
- showSearchPage()

đều lặp lại đoạn code:

    List<String> categories = Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    model.addAttribute("categories", categories);

---

## 2. Nguyên tắc bị vi phạm

Đoạn code trên vi phạm nguyên tắc:

### DRY (Don't Repeat Yourself)

> "Đừng lặp lại chính mình"

---

## 3. Hệ quả của việc vi phạm DRY

### 3.1. Khó bảo trì

Nếu thay đổi danh sách categories:

Ví dụ thêm:
"Ăn vặt"

→ Phải sửa ở:
- showAddForm
- showEditForm
- showSearchPage
  → Nếu có 20 API → sửa 20 chỗ

---

### 3.2. Dễ gây bug không đồng nhất

- Một API update, API khác quên update
  → UI hiển thị khác nhau
  → Lỗi nghiệp vụ

---

### 3.3. Controller bị phình to (Code Smell)

- Code lặp lại
- Khó đọc
- Khó mở rộng

---

## 4. Giải pháp

Sử dụng:

### Method-level @ModelAttribute của Spring MVC

---

## 5. Cơ chế hoạt động

- Method có @ModelAttribute sẽ được gọi trước mỗi request
- Dữ liệu được tự động add vào Model
- Tất cả các handler trong Controller đều dùng được

---

## 6. Lợi ích

- Viết 1 lần → dùng mọi nơi
- Code sạch hơn
- Dễ bảo trì
- Tuân thủ DRY