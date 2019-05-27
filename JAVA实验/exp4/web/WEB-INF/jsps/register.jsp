<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-5
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <h2>欢迎注册账号!</h2>
    <html:form action="/register" method="post">
        <bean:message key="info.input" arg0="账号"></bean:message>
        <html:text property="account"></html:text>
        <html:errors property="account"></html:errors><br>
        <bean:message key="info.input" arg0="密码"></bean:message>
        <html:password property="password"></html:password>
        <html:errors property="password"></html:errors><br>
        <bean:message key="info.input" arg0="确认密码"></bean:message>
        <html:password property="confirmPassword"></html:password>
        <html:errors property="confirmPassword"></html:errors>
        <html:errors property="notSamePassword"></html:errors><br>
        <bean:message key="info.input" arg0="姓名"></bean:message>
        <html:text property="name"></html:text>
        <html:errors property="name"></html:errors><br><br>
        <html:submit value="注册"></html:submit>
        <html:cancel value="取消"></html:cancel><br>
        <html:errors property="register"></html:errors>
    </html:form>
</body>
</html>
