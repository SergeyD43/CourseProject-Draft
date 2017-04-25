<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<h2>Приветствуем Вас на главной странице!</h2>
<% String name = (String) request.getSession().getAttribute("nameUser");%>
<h1>
    <%=name%>
</h1>
<form method="post" action="/main">
    <input type="submit" value="выход" name="exit"/>
</form>
</body>
</html>
