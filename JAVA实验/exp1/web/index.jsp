<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-4-9
  Time: 下午11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>初始菜单</title>
  </head>
  <body>
    <table border="2">
      <tr>
        <th>编号</th>
        <th>题目</th>
        <th>操作</th>
      </tr>
      <tr>
        <form action="chatframeset.html" method="post">
          <td>1.1</td>
          <td>简易聊天室</td>
          <td><input type="submit" value="前往"> </td>
        </form>
      </tr>
      <tr>
        <form action="login.jsp" method="post">
          <td>1.2</td>
          <td>登陆模块</td>
          <td><input type="submit" value="前往"> </td>
        </form>
      </tr>
      <tr>
        <form action="historyBooks.jsp" method="post">
          <td>1.3</td>
          <td>历史书目</td>
          <td><input type="submit" value="前往"> </td>
        </form>
      </tr>
      <tr>
        <form action="computerBooks.jsp" method="post">
          <td>1.4</td>
          <td>计算机书目</td>
          <td><input type="submit" value="前往"> </td>
        </form>
      </tr>
    </table>
  </body>
</html>
