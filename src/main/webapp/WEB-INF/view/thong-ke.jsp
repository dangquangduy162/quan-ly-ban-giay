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
    <h1 style="text-align: center">Top 10 san pham ban chay</h1>
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Ma giay</th>
            <th>Ten giay</th>
            <th>So luong da ban</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sanPham" items="${top10SanPham}" varStatus="index">
            <tr>
                <td>${index.index + 1}</td>
                <td>${sanPham.maGiay}</td>
                <td>${sanPham.tenGiay}</td>
                <td>${sanPham.soLuongBan}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>