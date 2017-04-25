<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница авторизации</title>
</head>
<body>
<h2>Авторизация</h2>
<form method="post" action="/login">
    <input placeholder="логин" type="text" name="login"/>
    <input placeholder="пароль" type="text" name="password"/>
    <input type="submit" value="login"/>
</form>

</body>
</html>
