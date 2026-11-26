<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.example.duanmu.entity.ChatLieu" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản lý chất liệu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 24px;
            color: #222;
        }
        h2 {
            margin-bottom: 14px;
        }
        form {
            display: flex;
            gap: 8px;
            align-items: center;
            margin-bottom: 18px;
        }
        input[type="text"] {
            padding: 7px 10px;
            border: 1px solid #bbb;
            border-radius: 4px;
            font-size: 14px;
        }
        button {
            padding: 7px 14px;
            border: none;
            border-radius: 4px;
            background-color: #1976d2;
            color: #fff;
            font-size: 14px;
            cursor: pointer;
        }
        button:hover {
            background-color: #1565c0;
        }
        table {
            border-collapse: collapse;
            width: 640px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px 12px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
<h2>Danh sách chất liệu</h2>

<form action="${pageContext.request.contextPath}/ChatLieuServlet" method="post">
    <input type="text" name="ma" placeholder="Mã chất liệu (VD: CL01)" required />
    <input type="text" name="ten" placeholder="Tên chất liệu" required />
    <button type="submit">Thêm mới</button>
</form>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên chất liệu</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<ChatLieu> dsChatLieu = (List<ChatLieu>) request.getAttribute("dsChatLieu");
        if (dsChatLieu != null && !dsChatLieu.isEmpty()) {
            for (ChatLieu item : dsChatLieu) {
    %>
    <tr>
        <td><%= item.getId() %></td>
        <td><%= item.getMa() %></td>
        <td><%= item.getTen() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Chưa có dữ liệu</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>