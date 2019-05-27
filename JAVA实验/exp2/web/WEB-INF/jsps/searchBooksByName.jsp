<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 下午5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>searchBooksByName</title>
</head>
<body>
    <form method="post" action="searchBooksByNameServlet">
        请输入需要查询的图书名称：<input type="text" name="bookName"><br><br>
        <input type="submit" value="查询">&nbsp;~&nbsp;
        <input type="reset" value="重置"><br>
    </form>
</body>
</html>
