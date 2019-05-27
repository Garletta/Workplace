<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-4-9
  Time: 下午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>talk</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");
        String newMessage = request.getParameter("message");
        if(newMessage != null) {
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
            newMessage = df.format(date) + "<br>" + request.getRemoteAddr() + "用户：<br>" + newMessage + "<br>";
            String oldMessage = (String) application.getAttribute("message");
            if(oldMessage != null) {
                newMessage = oldMessage + "<br>" + newMessage;
            }
            application.setAttribute("message",newMessage);
        }
    %>
    <form style="text-align: center" action="talk.jsp" method="post">
        <input type="text" name="message">&nbsp;<input type="submit" value="发送">
    </form>
</body>
</html>
