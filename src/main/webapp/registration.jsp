<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h2>Регистрация</h2>
<form method="post" action="/registration">
    <input placeholder="логин" type="text" name="login"/>
    <input placeholder="пароль" type="text" name="password"/>
    <input placeholder="имя" type="text" name="name"/>
    <input placeholder="фамилия" type="text" name="surname"/>
    <input placeholder="возраст" type="text" name="age"/>
    <input type="submit" value="registration"/>
</form>
</body>
</html>

