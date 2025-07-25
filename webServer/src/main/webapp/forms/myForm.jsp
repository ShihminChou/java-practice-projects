<%--
  Created by IntelliJ IDEA.
  User: shimin_zhou
  Date: 2025/7/17
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/sessionRegis" method="get">
    <label for="">Book ID:</label>
    <input type="text" name="bookId">
    <br>
    <label for="">Book name:</label>
    <input type="text" name="name">
    <br>
    <label for="">Price:</label>
    <input type="number" name="price">
    <br>
    <label for="">Author:</label>
    <input type="text" name="author">
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
