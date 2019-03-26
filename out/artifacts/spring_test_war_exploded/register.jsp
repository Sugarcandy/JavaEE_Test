<%--
  Created by IntelliJ IDEA.
  User: 19472
  Date: 2019/3/14 0014
  Time: 下午 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"
    ="text/css">
</head>
<style>
    fieldset {
        margin-left: 40%;
        width:300px;
        opacity:0.8;
        text-align: center;
    }
</style>
<body class="test">
<div class="logo">

</div>
<form action="/bean/RegisterServlet" method="post">
    <fieldset>
        <p>账  号  ：<input type="text" size="20" name="eno"><br>
        <p>密  码  ：<input type="password" size="20" name="pass"><br>
        <p>确  认  ：<input type="password" size="20" name="repass"><br>
        <p>姓  名  ：<input type="text" size="20" name="name"><br>
        <p>  <input type="submit" name="register" value="注册">
            <input type="reset" name="clear" value="清空"></p>
    </fieldset>
</form>
</body>
</html>
