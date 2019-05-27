<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-3
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <script language="JavaScript">
        function login() {
            var xmlHttp = false;
            if(window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else if(window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            }
            var account = document.loginForm.account.value;
            var password = document.loginForm.password.value;
            if(account == "" || password == "") {
                window.alert("请填写完整的登陆信息!");
            } else {
                var URL = "loginServlet?account=" + account + "&password=" + password;
                xmlHttp.open("post",URL,true);
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4) {
                        resultInfo.innerHTML = xmlHttp.responseText;
                    } else {
                        resultInfo.innerHTML += "正在登陆,请稍候...";
                    }
                }
                xmlHttp.send();
            }
        }
    </script>
    <h2>欢迎登陆!</h2><br><hr><br>
    <form method="post" action="register.jsp" name="loginForm">
        请输入账号：<input type="text" name="account"><br>
        请输入密码：<input type="password" name="password"><br><br>
        <input type="button" value="登陆" onclick="login()">&nbsp;~&nbsp;
        <input type="submit" value="注册"><br>
    </form><hr>
    <div id="resultInfo"></div>
</body>
</html>
