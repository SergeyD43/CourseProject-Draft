<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Авторизация</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/resources/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/resources/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/login">Школа иностранных языков</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <form method ="post" action="/registration" class="form-signin">
        <h2 class="my-title form-signin-heading">Регистрация</h2>
        <label for="login" class="sr-only"></label>
        <h2 class="simple-title">длина логина должна быть не менее 6 символов</h2>
        <input name ="login" type="text" id="login" class="form-control" placeholder="логин" required autofocus>
        <label for="password" class="sr-only"></label>
        <h2 class="simple-title">длина пароля должна быть не менее 8 символов, пароль должен содержать только символы из диапазона A-z0-9</h2>
        <input name ="password" type="text" id="password" class="form-control" placeholder="пароль" required autofocus>
        <label for="name" class="sr-only"></label>
        <h2 class="simple-title">Имя</h2>
        <input name ="name" type="text" id="name" class="form-control" placeholder="имя" required autofocus>
        <h2 class="simple-title">Фамилия</h2>
        <label for="surname" class="sr-only"></label>
        <input name ="surname" type="text" id="surname" class="form-control" placeholder="фамилия" required autofocus>
        <%--<label for="password" class="sr-only">Password</label>--%>
        <%--<input name="password" type="password" id="password" class="form-control" placeholder="Password" required>--%>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироваться</button>
        <c:if test="${not empty errCode}">
            <h1 class="error-title">${errCode}</h1>
        </c:if>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

