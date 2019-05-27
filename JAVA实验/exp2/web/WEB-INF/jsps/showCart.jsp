<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 下午7:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beans.Book" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>showCart</title>
</head>
<body>
<table border="2">
    <tr>
        <th colspan="3">购物车</th>
    </tr>
    <tr>
        <th>图书编号</th>
        <th>图书名称</th>
        <th>图书价格</th>
    </tr>
    <%
        ArrayList<Book> carts = (ArrayList<Book>) session.getAttribute("carts");
        if(carts != null) {
            for(int i = 0;i < carts.size();i++) {
    %>
    <tr>
        <td><%=carts.get(i).getBOOKID()%></td>
        <td><%=carts.get(i).getBOOKNAME()%></td>
        <td><%=carts.get(i).getBOOKPRICE()%></td>
        <td><a href="deleteCartServlet?BOOKID=<%=carts.get(i).getBOOKID()%>">从购物车中删除</a> </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
