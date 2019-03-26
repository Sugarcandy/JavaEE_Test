<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>办公系统后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"
          type="text/css">
</head>
<style>
    fieldset {
        margin-left: 35%;
        width:400px;
        opacity:0.8;
        text-align: center;
    }
</style>
<body class =test>
<div class="logo">

</div>
<%
    String username = "";
    String password = "";
    String s;
    Cookie [] cookies =request.getCookies();
    if(cookies!=null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                username = cookie.getValue();
                request.setAttribute("useId", username);

            } else if (cookie.getName().equals("password")) {
                password = cookie.getValue();
                request.setAttribute("password", password);
            }
        }
    }
%>
<form action="/bean/LoginServlet" method="post">
    <fieldset>
        <br>
        账&nbsp;&nbsp;号：&nbsp;&nbsp;<input type="text" size="20" name="user" value="${useId}"><br><br>
        密&nbsp;&nbsp;码：&nbsp;&nbsp;<input type="password" size="20" name="password"
                  value="${password}"><br><br>
        <input type="checkbox" name="remeber" value="r">记住密码<br><br>
        <input type="submit" value="登录"> &nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">立即注册</a>
    </fieldset>
</form>
</body>
</html>
