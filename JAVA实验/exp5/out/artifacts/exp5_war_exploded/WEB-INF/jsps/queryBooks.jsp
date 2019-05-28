<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-10
  Time: 上午11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>queryBooks</title>
</head>
<body>
    <h2>欢迎使用图书检索系统!</h2><hr>
    <form action="queryByPrice.action" method="post">
        请输入图书价格区间：<br>
        <input type="text" name="priceMin">&nbsp;到 &nbsp;
        <input type="text" name="priceMax"><br><br>
        <input type="submit" value="查询">
    </form><hr>
    <form action="queryByName.action" method="post">
        请输入图书名称：<input type="text" name="bookName"><br>
        请输入最高价格：<input type="text" name="maxPrice"><br><br>
        <input type="submit" value="查询">
    </form><hr>
</body>
</html>
