<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-10
  Time: 上午11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Table.TBookEntity" %>
<html>
<head>
    <title>showBooks</title>
</head>
<body>
    <h2>查询结果如下：</h2><hr>
    <table border="2">
        <tr>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书价格</th>
        </tr>
        <%
            ArrayList<TBookEntity> books = (ArrayList) session.getAttribute("books");
            if(books != null) {
                for(int i = 0;i < books.size();i++) {
        %>
        <tr>
            <td><%=books.get(i).getBookid()%></td>
            <td><%=books.get(i).getBookname()%></td>
            <td><%=books.get(i).getBookprice()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
