<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-5
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <html:form action="/login">
        <bean:message key="info.input" arg0="账号"></bean:message>
        <html:text property="account"/>
        <html:errors property="account"/> <br>
        <bean:message key="info.input" arg0="密码"></bean:message>
        <html:password property="password"/>
        <html:errors property="password"/> <br><br>
        <html:submit value="登陆"/>  <html:cancel value="取消"/>
        <html:errors property="login"></html:errors>
    </html:form>
    <hr>
    <a href="register.jsp">注册新账号</a>
</body>
</html>
