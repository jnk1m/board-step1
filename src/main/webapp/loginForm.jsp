<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:bundle basename="language">
    <title><fmt:message key="LoginPage"/></title>
</head>
<body>
<h1><fmt:message key="LoginPage"/></h1>
<form method="post" action="/login.do">
    <fmt:message key="Id"/>  <input type="text" name="id"/><br/>
    <fmt:message key="Password"/>  <input type="password" name="password"><br/>
    <input type="submit">
</form>
<a href="language.do?language=en"><fmt:message key="en"/></a>
<a href="language.do?language=ko"><fmt:message key="ko"/></a><br/>
<br/>
<a href="signUpForm.jsp"><fmt:message key="SignUpPage"/></a>
</fmt:bundle>
</body>
</html>
