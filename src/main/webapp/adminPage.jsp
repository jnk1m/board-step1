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
    <h3><fmt:message key="UserList"/></h3>
    <c:set var="userRepository" value="${applicationScope.userRepository}"/>
    <c:set var="userList" value="${userRepository.getUsers()}"/>
    <table border="1">
        <c:forEach items="${userList}" var="user">
            <tr>
                <form method="post" action="/eachUser.do">
                    <td><input type="checkbox" name="userId" value="${user.getId()}"></td>
                    <td><fmt:message key="Name"/>: <c:out value="${user.getName()}"/></td>
                    <td><fmt:message key="Profile"/>: <c:out value="${user.getProfileFileName()}"/></td>
                    <td><input type="submit" value="<fmt:message key="Go"/>"></td> <br/>
                </form>
            </tr>
        </c:forEach>
    </table>

    </body>
</fmt:bundle>
</html>
