<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String message = (String) request.getAttribute("value");%>
<h1>
    <%=message%>
</h1>
<table>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td><c:out value="${user.idUser}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.surname}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
