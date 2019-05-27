<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-1
  Time: 上午10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
    <%
        String flag = request.getParameter("flag");
        String hadKeep = null;
        Cookie[] cookies = request.getCookies();
        for(int i = 0;i < cookies.length;i++) {
            System.out.println(cookies[i].getName() + "====" + cookies[i].getValue());
            if(cookies[i].getName().equals(cookies[i].getValue())) {
                hadKeep = cookies[i].getName();
                break;
            }
        }
        if(hadKeep == null && flag == null) {
    %>
            <jsp:forward page="login.jsp"></jsp:forward>
    <%
        }
    %>
    登陆成功,欢迎!
</body>
</html>
