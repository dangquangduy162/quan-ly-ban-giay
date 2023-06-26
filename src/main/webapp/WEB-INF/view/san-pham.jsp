<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
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
<section class="container" style="text-align: center">
    <h1>DANH SÁCH GIÀY LƯỜI</h1>
</section>
<section class="container" style=" margin-left: 120px">
    <div class="row">
        <div class="col-lg-6">
            <form action="">
                <div class="input-group">
                    <input type="text" class="form-control rounded" placeholder="Search" aria-label="Search"
                           aria-describedby="search-addon" name="tenGiay" value="${param.tenGiay}"/>
                    <button type="submit" class="btn btn-outline-primary">search</button>
                </div>
            </form>
        </div>
        <div class="col-lg-6">
            <form action="" method="get">
                    <select class="form-select" name="mauSac" aria-label="Default select example" onchange="this.form.submit()">
                        <option value="">Loc mau sac</option>
                        <option value="Black">Black</option>
                        <option value="red">red</option>
                        <option value="Yellow">Yellow</option>
                        <option value="white">white</option>
                        <option value="gray">gray</option>
                    </select>
            </form>
        </div>

    </div>


</section>

<section class="container">


    <c:if test="${empty pageSanPham.isEmpty()}">
        <h2> Not found any records!! </h2>
    </c:if>
    <c:if test="${not empty pageSanPham.isEmpty()}">
        <p style="margin-left: 120px">Found ${pageSanPham.getTotalElements()} records</p>
        <form action="/assignment/san-pham/add" method="get">
            <button type="submit" class="btn btn-success">ADD</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Ten giay</th>
                <th scope="col">Gia Ban</th>
                <th scope="col">So Luong</th>
                <th scope="col">Mo ta</th>
                <th scope="col">Mau sac</th>
                <th scope="col">Chat lieu</th>
                <th scope="col"></th>
                <th scope="col">Function</th>
                <th scope="col"></th>
                <th scope="col">Mua hang</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageSanPham.getContent()}" var="sp">
                <tr>

                    <td>${sp.maGiay}</td>
                    <td>${sp.tenGiay}</td>
                    <td>${sp.giaBan}</td>
                    <td>${sp.soLuong}</td>
                    <td>${sp.moTa}</td>
                    <td>${sp.mauSac}</td>
                    <td>${sp.chatLieu}</td>
                    <td>
                        <a href="" style="background: rgba(0, 0, 0, 0);">
                            <form action="/assignment/san-pham/delete?id=${sp.maGiay}" method="post">
                                <button type="submit" class="btn btn-outline-danger"
                                        onclick="return confirm('Are you sure ?')">Delete
                                </button>
                            </form>
                        </a>

                    </td>
                    <td>
                        <a href="/assignment/san-pham/update?id=${sp.maGiay}" style=" background: rgba(0, 0, 0, 0);">
                            <button type="submit" class="btn btn-outline-primary">Update</button>
                        </a>
                    </td>
                    <td>
                        <a href="/assignment/san-pham/detail?id=${sp.maGiay}" style=" background: rgba(0, 0, 0, 0);">
                            <button type="submit" class="btn btn-outline-info">Detail</button>
                        </a>
                    </td>
                    <td>
                        <form action="/assignment/gio-hang/them-san-pham" method="post">
                            <input type="hidden" name="maGiay" value="${sp.maGiay}">
                            <input type="number" name="soLuongThem"  placeholder="so luong san pham" required min="1">
                            <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Are you sure?')">Add to cart</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
        <div style="text-align: center">
            <c:if test="${pageSanPham.getNumber() + 1 >1}">
                <a href="?page=${pageSanPham.getNumber() + 1 - 1}&tenGiay=${param.tenGiay}&mauSac=${param.mauSac}" class="previous">&laquo;
                    Previous</a>
            </c:if>

            <span> ${pageSanPham.getNumber() + 1} / ${pageSanPham.getTotalPages()} </span>
            <c:if test="${pageSanPham.getNumber() +1 < pageSanPham.getTotalPages()}">
                <a href="?page=${pageSanPham.getNumber() + 1 + 1}&tenGiay=${param.tenGiay}&mauSac=${param.mauSac}" class="next">Next
                    &raquo;</a>
            </c:if>

        </div>
    </c:if>
</section>

</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>