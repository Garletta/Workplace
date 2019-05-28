<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-14
  Time: 下午5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>queryBook</title>
</head>
<body>
    <h2>欢迎使用图书查询系统!</h2><hr>
    <form action="queryByKeyWord.action" method="post">
        请输入查询图书关键字：<input type="text" name="keyWord"><br><br>
        <input type="submit" value="查询">
    </form>
</body>
</html>