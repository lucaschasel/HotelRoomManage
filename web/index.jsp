<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>酒店房间管理系统</title>
</head>
<body>
<h1>酒店房间管理系统</h1>
<form action="RoomController" method="get">
  <label for="hotelName">名称:</label>
  <input type="text" id="hotelName" name="hotelName" />
  <input type="submit" value="查询" />
  <a href="RoomController?action=add">添加</a>
</form>

<table border="1">
  <tr>
    <th>ID</th>
    <th>酒店名称</th>
    <th>房型</th>
    <th>价格</th>
    <th>描述</th>
    <th>操作</th>
  </tr>
  <c:forEach var="room" items="${rooms}">
    <tr>
      <td>${room.id}</td>
      <td>${room.hotelName}</td>
      <td>${room.type}</td>
      <td>${room.price}</td>
      <td>${room.info}</td>
      <td><a href="RoomController?action=delete&id=${room.id}">删除</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
