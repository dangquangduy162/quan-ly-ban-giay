<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<section class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/assignment/san-pham">Shoe Store</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/assignment/san-pham">Trang chu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/assignment/thong-ke/top10sanpham">Thong ke</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/assignment/gio-hang">Gio Hang</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/assignment/hoa-don">Hoa don</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</section>
<section class="container">
    <h1 style="text-align: center">Gio Hang</h1>
    <a href="/assignment/san-pham">
        <button type="button" class="btn btn-success">Quay lai mua hang</button>
    </a>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">Ma Pham</th>
            <th scope="col">Ten san pam</th>
            <th scope="col">So Luong</th>
            <th scope="col">Gia</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sanPham" items="${gioHangViewModel.sanPhamTrongGios}">
            <tr>
                <td>${sanPham.maGiay}</td>
                <td>${sanPham.tenGiay}</td>
                <td>${sanPham.soLuong}</td>
                <td>${sanPham.giaBan * sanPham.soLuong}</td>
                <td>
                    <form action="/assignment/gio-hang/bo-san-pham" method="post">
                        <input type="hidden" name="maGiay" value="${sanPham.maGiay}">
                        <button type="submit" class="btn btn-outline-danger"
                                onclick="return confirm('Are you sure?')">Remove
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>
        <p style="float: left">Tong tien: ${gioHangViewModel.tongTien}</p>
        <form style="float: right" action="/assignment/gio-hang/xoa-toan-bo-san-pham" method="post">
            <button type="submit" class="btn btn-danger">Clear</button>
        </form>
    </div>


</section>
<section class="container" style="clear: both">
    <form method="post" action="/assignment/gio-hang/mua-hang">
        <div class="mb-3">
            <label for="soDienThoai"  class="form-label">So dien thoai:</label>
            <input style="width: 500px" type="text" class="form-control" id="soDienThoai" name="soDienThoai">
        </div>
        <button type="submit" class="btn btn-success">Thanh toan</button>
    </form>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>