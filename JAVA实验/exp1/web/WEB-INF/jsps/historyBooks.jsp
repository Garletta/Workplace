<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>historyBooks</title>
</head>
<body>
    <table border="2" >
        <tr>
            <th>书名</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>华夏五千年</td>
            <td>78.5</td>
            <td><a href="historyBooks.jsp?book=华夏五千年">购买</a> </td>
        </tr>
        <tr>
            <td>商鞅变法</td>
            <td>43.7</td>
            <td><a href="historyBooks.jsp?book=商鞅变法">购买</a> </td>
        </tr>
        <tr>
            <td>贞观之治</td>
            <td>66</td>
            <td><a href="historyBooks.jsp?book=贞观之治">购买</a> </td>
        </tr>
        <tr>
            <td>改革开放</td>
            <td>87.8</td>
            <td><a href="historyBooks.jsp?book=改革开放">购买</a> </td>
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
