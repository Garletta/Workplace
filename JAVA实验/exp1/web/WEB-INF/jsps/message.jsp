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
    <title>message</title>
    <meta http-equiv="refresh" content="2">
</head>
<body>
    <%
        String newMessage = (String) application.getAttribute("message");
        if(newMessage != null) {
            out.print(newMessage);
        }
    %>
</body>
</html>
