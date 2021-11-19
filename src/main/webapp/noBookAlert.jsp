<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/19/2021
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${message}</title>
    <style>
        *{
            margin: auto;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 >Lỗi!!!</h1>
<%--<p>Cuốn sách này tạm thời đã hết, hãy quay lại chọn sách khác</p><br>--%>
<p>Có Lỗi Xảy ra</p><br>
<p>${message}</p>
<br>
<a href="/books">Quay Lại</a>

</body>
</html>
