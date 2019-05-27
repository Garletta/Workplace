<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 下午6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Book" %>
<html>
<head>
    <title>showBooks</title>
</head>
<body>
    <table border="2">
        <tr>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书价格</th>
        </tr>
        <%
            ArrayList<Book> books = (ArrayList<Book>) session.getAttribute("books");
            if(books != null) {
                for(int i = 0;i < books.size();i++) {
        %>
        <tr>
            <td><%=books.get(i).getBOOKID()%></td>
            <td><%=books.get(i).getBOOKNAME()%></td>
            <td><%=books.get(i).getBOOKPRICE()%></td>
            <td><a href="addCartServlet?BOOKID=<%=books.get(i).getBOOKID()%>">添加到购物车</a> </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <hr>
    <a href="showCart.jsp">查看购物车</a>
</body>
</html>
