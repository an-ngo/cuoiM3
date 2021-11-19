<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/19/2021
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2  /dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 style="margin: auto;text-align: center;">Card Form</h1>

<div class="container w-50">
    <form method="post">
        <div class="mb-3">
            <label for="idBook" class="form-label">Mã Mượn Sách</label>
            <input name="idBook" type="number" class="form-control" id="idBook" aria-describedby="emailHelp" value="${book.idBook}">
        </div>
        <div class="mb-3">
            <label for="bookName" class="form-label">Tên Sách</label>
            <input name="bookName" type="text" class="form-control" id="bookName" value="${book.name}">
        </div>
        <div class="mb-3">
            <label for="studentName" class="form-label">Tên Học Sinh</label>
            <select name="idStudent" id="studentName" class="w-50">
                <c:forEach var="t" items="${listStudent}">
                    <option value="${t.idStudent}">${t.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="ngayMuon" class="form-label">Ngày mượn</label>
            <input name="borrowDate" type="date" class="form-control" id="ngayMuon" >
        </div>
        <div class="mb-3">
            <label for="ngayTra" class="form-label">Ngày Trả</label>
            <input name="returnDate" type="date" class="form-control" id="ngayTra" >
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/books" style="padding: 0.3em;" class="border border-1">Hủy</a>
    </form>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>