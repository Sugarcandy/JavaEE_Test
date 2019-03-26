<%--
  Created by IntelliJ IDEA.
  User: 19472
  Date: 2019/3/14 0014
  Time: 下午 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录成功</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"
          type="text/css">
</head>

<body class="test">

<div align="center">
    <table border="1" width="80%">
        <caption><font size="25">产品列表</font></caption>
        <tr>
            <th width="20%">产品编号</th>
            <th width="20%">产品名称</th>
            <th width="20%">产品单价</th>
            <th width="20%">生产地</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr align="center">
                <td>${product.getProductId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getAddress()}</td>
                <td>
                    <input type="button" value="加入购物车"
                           onclick="add_to_cart(${product.getProductId()})"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div width="80%">
        <br>
        <input type="button" value="查看购物车" onclick="view_cart()"
               style="margin-left: 64%"/>
    </div>


</div>

</body>
<script>
    function add_to_cart(productId) {
        alert("添加成功！");
        window.location="/bean/CartServlet?productId="+productId;
    }

    function view_cart() {
        window.location="/viewCart.jsp";
    }
</script>
</html>
