<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <style>
        a {
            text-decoration: none;
            display: inline-block;
            padding: 8px 16px;
        }

        a:hover {
            background-color: #ddd;
            color: black;
        }

        .previous {
            background-color: #f1f1f1;
            color: black;
        }

        .next {
            background-color: #04AA6D;
            color: white;
        }

        .round {
            border-radius: 50%;
        }
    </style>
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
    <h1 style="text-align: center">Hoa don chi tiet</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Ma san pham</th>
            <th>Ten san pham</th>
            <th>So luong</th>
            <th>Gia ban</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="chiTietHoaDon" items="${chiTietHoaDonList}">
            <tr>
                <td>${chiTietHoaDon.maGiay}</td>
                <td>${chiTietHoaDon.tenGiay}</td>
                <td>${chiTietHoaDon.soLuong}</td>
                <td>${chiTietHoaDon.giaBan}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>




</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>