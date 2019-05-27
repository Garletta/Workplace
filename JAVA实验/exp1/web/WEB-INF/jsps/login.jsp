<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 上午10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        for(int i = 0;i < cookies.length;i++) {
            System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());
            if(cookies[i].getName().equals(cookies[i].getValue())) {
    %>
                <jsp:forward page="welcome.jsp"></jsp:forward>
    <%
                break;
            }
        }
    %>
    <form method="post" action="loginResult.jsp">
        账号：<input type="text" name="account" value=""><br>
        密码：<input type="password" name="passwd" value=""><br>
        <input type="radio" name="isKeep" value="true">保存登陆状态<br>
        <input type="submit" value="登陆">&nbsp;~&nbsp;
        <input type="reset" value="重置"><br>
    </form>
</body>
</html>
