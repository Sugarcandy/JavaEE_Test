<%--
  Created by IntelliJ IDEA.
  User: 19472
  Date: 2019/3/22 0022
  Time: 上午 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结账</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"
      type="text/css">
<body class="test">
<div align="center">
    你好！${yourName}<br>
    付款总金额为：${param.total}元
</div>
</body>
</html>
