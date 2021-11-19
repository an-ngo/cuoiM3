<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/19/2021
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Card</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2  /dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã Thẻ Mượn</th>
            <th scope="col">Tên Sách</th>
            <th scope="col">Tác Giả</th>
            <th scope="col">Tên Học Sinh</th>
            <th scope="col">Lớp</th>
            <th scope="col">Ngày Mượn</th>
            <th scope="col">Ngày Trả</th>
            <th scope="col">Trả Sách</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCard}" var="t">
            <c:if test="${t.status==0}">

            <tr>
                <th scope="row">MS-${t.idCard}</th>
                <td>${t.book.getName()}</td>
                <td>${t.book.getAuthor()}</td>
                <td>${t.student.getName()}</td>
                <td>${t.student.getClassName()}</td>
                <td>${t.borrowDate}</td>
                <td>${t.returnDate}</td>

                <td>
                        <form action="">
                            <input type="submit" name="" id="" value="Trả Sách">
                            <input type="hidden" name="idCard" value="${t.idCard}">
                            <input type="hidden" name="action" value="returnBook">
                        </form>
                </td>

            </tr>
            </c:if>

        </c:forEach>
        </tbody>
    </table>
    <a href="/books"> Quay Lại</a>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
