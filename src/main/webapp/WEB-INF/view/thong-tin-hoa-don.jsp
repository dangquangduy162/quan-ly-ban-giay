<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<section class="container">
    <a href="/assignment/san-pham">
        <button type="button" class="btn btn-success">Quay lai mua hang</button>
    </a>
    <h1 style="text-align: center">Hoa Don</h1>

    <p>So dien thoai: ${hoaDon.soDienThoai}</p>
    <p>Ngay tao: ${hoaDon.ngayTao}</p>
    <p>Tong tien thanh toan: ${hoaDon.tongTien}</p>

    <h2>Danh sach san pham</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Ma san pham</th>
            <th scope="col">Ten san pham</th>
            <th scope="col">So luong</th>
            <th scope="col">Gia ban</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hoaDonChiTiet" items="${hoaDonChiTietList}">
            <tr>
                <td>${hoaDonChiTiet.maGiay}</td>
                <td>${hoaDonChiTiet.tenGiay}</td>
                <td>${hoaDonChiTiet.soLuong}</td>
                <td>${hoaDonChiTiet.giaBan}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>