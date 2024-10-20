<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房间列表</title>
</head>
<body>
<h1>房间列表</h1>
<a href="RoomController?action=add">添加新房间</a>
<table border="1">
    <tr>
        <th>房间ID</th>
        <th>类型</th>
        <th>价格</th>
        <th>描述</th>
        <th>酒店ID</th>
    </tr>
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.id}</td>
            <td>${room.type}</td>
            <td>${room.price}</td>
            <td>${room.info}</td>
            <td>${room.hotelId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>