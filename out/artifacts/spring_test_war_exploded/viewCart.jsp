
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"
      type="text/css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>查看购物车</title>
</head>
<body class="test">
<table border="1" align="center" width="80%">
    <caption>购物车</caption>
    <tr>
        <th width="25%">产品名称</th>
        <th width="25%">数量</th>
        <th width="25%">单价</th>
        <th width="25%">小计</th>
    </tr>
    <c:forEach var="item" items="${prolist}">
        <tr align="center">
            <td>${item.getProduct().getProductName()}</td>
            <td>${item.getCount()}</td>
            <td>${item.getProduct().getPrice()}</td>
            <td>${item.getTotal()}</td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="3">合计</td>
        <td>${cart.getTotal()}</td>
    </tr>
    <tr>
        <td colspan="4" align="center">
            <input type="button" value="结账" onclick="check(${cart.getTotal()})">
        </td>

    </tr>
</table>

</body>
<script>
    function check(total) {
        window.location="checkbill.jsp?total="+total;
    }
</script>
</html>
