<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-14
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>start</title>
</head>
<body>
  <h2>实验6</h2><hr>
  <table border="2">
    <tr>
      <th></th>
      <th>题目</th>
      <th>操作</th>
    </tr>
    <tr>
      <form action="WEB-INF/JSP/queryBook.jsp" method="post">
      <td>6.1</td>
      <td>模糊查询图书</td>
      <td><input type="submit" value="进入"></td>
      </form>
    </tr>
    <tr>
      <form action="deleteBook.action" method="post">
      <td>6.2</td>
      <td>全部图书资料</td>
      <td><input type="submit" value="进入"></td>
      </form>
    </tr>
  </table>
</body>
</html>
