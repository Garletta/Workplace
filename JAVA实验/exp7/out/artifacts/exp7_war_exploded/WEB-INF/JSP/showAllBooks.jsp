<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-15
  Time: 下午6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Table.TBook" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<html>
<head>
    <title>showAllBooks</title>
</head>
<body>
    <h2>全部图书资料如下：</h2><hr>
    <table border="2">
        <tr>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书价格</th>
            <th>操作</th>
        </tr>
        <%
            Map se = ActionContext.getContext().getSession();
            ArrayList<TBook> books = (ArrayList<TBook>) se.get("list");
            for(int i = 0;i < books.size();i++) {
        %>
        <tr>
            <form action="deleteBook.action" method="post">
                <input type="hidden" name="bookID" value="<%=books.get(i).getBookid()%>">
            <td><%=books.get(i).getBookid()%></td>
            <td><%=books.get(i).getBookname()%></td>
            <td><%=books.get(i).getBookprice()%></td>
            <td><input type="submit" value="删除"></td>
            </form>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
