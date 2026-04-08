# BÀI 4 – HIỂN THỊ DỮ LIỆU RA JSP

## 1. Data Flow

URL:
`/bai4/products?category=chay&limit=10`

↓

Controller nhận:

* category (String)
* limit (int)

↓

Controller đưa vào ModelMap:

* key: "category" → value: category
* key: "limit" → value: limit
* key: "message" → value: "Tìm kiếm thành công"

↓

View:

* File JSP: `productList.jsp`

↓

Hiển thị:

* category
* limit
* message

---

## 2. Kết quả mong đợi

Trình duyệt hiển thị:

* Loại món: chay
* Số lượng: 10
* Thông báo: Tìm kiếm thành công
