<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-3
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <script language="JavaScript">
        function register() {
            var xmlHttp = false;
            if(window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else if(window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            }
            var account = document.registerForm.account.value;
            var password = document.registerForm.password.value;
            var confirmPassword = document.registerForm.confirmPassword.value;
            var name = document.registerForm.name.value;
            if(account == "" || password == "" || confirmPassword == "" || name == "") {
                window.alert("请填写完整的注册信息!");
            } else {
                var url = "registerServlet?account=" + account + "&password=" + password + "&confirmPassword=" + confirmPassword + "&name=" + name;
                xmlHttp.open("post",url,true);
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4) {
                        resultInfo.innerHTML = xmlHttp.responseText;
                    } else {
                        resultInfo.innerHTML += "正在注册,请稍后...";
                    }
                }
                xmlHttp.send();
            }
        }
    </script>
    <h2>欢迎注册!</h2><br><hr><br>
    <form name="registerForm">
        请输入姓名：<input type="text" name="name"><br>
        请输入账号：<input type="text" name="account"><br>
        请输入密码：<input type="password" name="password"><br>
        请确认密码：<input type="password" name="confirmPassword"><br><br>
        <input type="button" value="注册" onclick="register()"><br><br>
    </form><hr>
    <div id="resultInfo"></div>
</body>
</html>
