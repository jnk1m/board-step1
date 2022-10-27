<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:bundle basename="language">
<head>
    <title><fmt:message key="AdminPage"/></title>
</head>
<body>
<h1><fmt:message key="AdminPage"/></h1>

<%--사용자 조회 화면에서는 이름과 프로필 이미지만 보여준다

--%>
<c:forEach items="${sessionScope.cart.getItems()}" var="item">
    <input type="checkbox" name="itemQty" value="${item.getQuantity()}">
    <input type="hidden" name="itemName" value="${item.getName()}"/>
    <fmt:message key="Name"/>: ${item.getName()} |
    <fmt:message key="Won"/>: ${item.getPrice()} | <fmt:message key="Quantity"/>: ${item.getQuantity()}<br/>
</c:forEach>

</body>
</fmt:bundle>
</html>
