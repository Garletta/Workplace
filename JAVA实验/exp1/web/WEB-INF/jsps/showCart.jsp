<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 下午2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showCart</title>
</head>
<body>
    <table border="2">
        <tr>
            <th colspan="2">购物车</th>
        </tr>
        <%
            ArrayList books = (ArrayList) session.getAttribute("books");
            String book = request.getParameter("delete");
            if(book != null) {
                books.remove(book);
            }
            if(books != null) {
                for(int i = 0;i < books.size();i++) {
        %>
        <tr>
            <td><%=books.get(i)%></td>
            <td><a href="showCart.jsp?delete=<%=books.get(i)%>">删除</a> </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <hr>
    <a href="http://localhost:8080/exp1_war_exploded/">返回</a>
</body>
</html>
