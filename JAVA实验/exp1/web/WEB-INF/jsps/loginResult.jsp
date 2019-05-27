<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 上午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginResult</title>
</head>
<body>
    <%
        boolean isKeep = Boolean.parseBoolean(request.getParameter("isKeep"));
        String account = request.getParameter("account");
        String password = request.getParameter("passwd");

        if(account != null && password != null && !account.equals("") && !password.equals("") && account.equals(password)) {
            if(isKeep == true) {
                Cookie cookie = new Cookie(account,password);
                cookie.setMaxAge(20);
                response.addCookie(cookie);
                System.out.println(account + ":::::" + password);
            }
    %>
            <jsp:forward page="welcome.jsp?flag=1"></jsp:forward>
    <%
        } else {
            out.print("登陆失败!");
        }
    %>
</body>
</html>
