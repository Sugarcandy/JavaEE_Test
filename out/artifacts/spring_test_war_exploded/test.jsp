<%--
  Created by IntelliJ IDEA.
  User: 19472
  Date: 2019/3/26 0026
  Time: 下午 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int[] a={1,2,3,4,5};
    request.setAttribute("a",a);
%>
<c:forEach var="item" items="${a}">
    <c:out value="100"></c:out>
</c:forEach>
</body>
</html>
