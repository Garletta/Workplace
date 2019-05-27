<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 下午3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>computerBooks</title>
</head>
<body>
    <table border="2" >
        <tr>
            <th>书名</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>计算机组成原理</td>
            <td>48.5</td>
            <td><a href="computerBooks.jsp?book=计算机组成原理">购买</a> </td>
        </tr>
        <tr>
            <td>操作系统</td>
            <td>33.7</td>
            <td><a href="computerBooks.jsp?book=操作系统">购买</a> </td>
        </tr>
        <tr>
            <td>数据结构</td>
            <td>57</td>
            <td><a href="computerBooks.jsp?book=数据结构">购买</a> </td>
        </tr>
        <tr>
            <td>数据库基础</td>
            <td>43.8</td>
            <td><a href="computerBooks.jsp?book=数据库基础">购买</a> </td>
        </tr>
        <tr>
            <td>编译原理</td>
            <td>73.9</td>
            <td><a href="computerBooks.jsp?book=编译原理">购买</a> </td>
        </tr>
    </table>
    <%
        ArrayList books = (ArrayList) session.getAttribute("books");
        if(books == null) {
            books = new ArrayList();
            session.setAttribute("books",books);
        }
        String book = request.getParameter("book");
        if(book != null) {
            book = new String(book.getBytes("utf-8"));
            books.add(book);
        }
    %>
    <hr>
    <a href="showCart.jsp">显示购物车</a>
</body>
</html>
