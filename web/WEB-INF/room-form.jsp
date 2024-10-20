<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加新房间</title>
</head>
<body>
<h1>添加新房间</h1>
<form action="RoomController?action=insert" method="post">
    <label>房间类型:</label>
    <input type="radio" name="type" value="1"> 标准间
    <input type="radio" name="type" value="2"> 豪华间
    <input type="radio" name="type" value="3"> 总统套间
    <br>

    <label>价格:</label>
    <input type="text" name="price" required>
    <br>

    <label>所属酒店:</label>
    <select name="hotelId">
        <c:forEach var="hotel" items="${hotels}">
            <option value="${hotel.id}">${hotel.name}</option>
        </c:forEach>
    </select>
    <br>

    <label>描述:</label>
    <textarea name="info"></textarea>
    <br>

    <input type="submit" value="提交">
</form>
</body>
</html>
