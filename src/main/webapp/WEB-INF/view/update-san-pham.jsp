<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<section class="container" style="text-align: center">
    <h1>UPDATE SAN PHAM</h1>
</section>
<section class="container">
    <form action="/assignment/san-pham/update" method="post">
        <div class="row">
            <div class="col-lg-6">
                <div class="mb-3">
                    <label class="form-label">ID giay</label>
                    <input type="text" class="form-control" readonly name="maGiay" value="${sanPham.maGiay}">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="mb-3">
                    <label class="form-label">Ten giay</label>
                    <input type="text" class="form-control" name="tenGiay" value="${sanPham.tenGiay}">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="mb-3">
                    <label class="form-label">Gia ban</label>
                    <input type="number" class="form-control" name="giaBan" value="${sanPham.giaBan}">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="mb-3">
                    <label class="form-label">So luong</label>
                    <input type="number" class="form-control" name="soLuong" value="${sanPham.soLuong}">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="mb-3">
                    <label class="form-label">Mau sac</label>
                    <input type="text" class="form-control" name="mauSac" value="${sanPham.mauSac}">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="mb-3">
                    <label class="form-label">Chat lieu</label>
                    <input type="text" class="form-control" name="chatLieu" value="${sanPham.chatLieu}">
                </div>
            </div>


        </div>
        <div class="mb-3">
            <label class="form-label">Mo ta</label>
            <input type="text" class="form-control" name="moTa" value="${sanPham.moTa}">
        </div>

        <button type="submit" onclick="return confirm('Are you sure ?')" class="btn btn-outline-success">Update</button>
    </form>

</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>