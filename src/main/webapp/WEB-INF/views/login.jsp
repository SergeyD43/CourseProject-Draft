<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<html>--%>
<%--<head>--%>
    <%--<title>Страница авторизации</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Авторизация</h2>--%>
<%--<form method="post" action="<c:url value='/j_spring_security_check' />">--%>
    <%--<input placeholder="логин" type="text" name="login"/>--%>
    <%--<input placeholder="пароль" type="text" name="password"/>--%>
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <%--<input type="submit" value="login"/>--%>
<%--</form>--%>
<%--&lt;%&ndash;<form method ="post" action="/login" class="form-signin">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<h2 class="my-title form-signin-heading">Авторизация</h2>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<label for="login" class="sr-only">login</label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<input name ="login" type="text" id="login" class="form-control" placeholder="логин" required autofocus>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<label for="password" class="sr-only">Password</label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<input name="password" type="password" id="password" class="form-control" placeholder="пароль" required>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>

<%--</body>--%>
<%--</html>--%>

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
    <!--[if lt IE 9]><script src="/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

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
            <a class="navbar-brand" href="#">Школа иностранных языков</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="#">Dashboard</a></li>--%>
                <%--<li><a href="#">Settings</a></li>--%>
                <%--<li><a href="#">Profile</a></li>--%>
                <%--<li><form method="post" action="/main">--%>
                <%--<input class="btn btn-primary" type="submit" value="выход" name="exit"/>--%>
                <%--</form></li>--%>
            </ul>
            <%--<form class="navbar-form navbar-right">--%>
            <%--<input type="text" class="form-control" placeholder="Search...">--%>
            <%--</form>--%>
        </div>
    </div>
</nav>

<div class="container">

    <%--<h2>Авторизация</h2>--%>
    <%--<form method="post" action="<c:url value='/j_spring_security_check' />">--%>
        <%--<input placeholder="логин" type="text" name="login"/>--%>
        <%--<input placeholder="пароль" type="text" name="password"/>--%>
        <%--&lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;--%>
        <%--<input type="submit" value="login"/>--%>
    <%--</form>--%>

    <form method ="post" action="<c:url value='/j_spring_security_check' />" class="form-signin">
        <h2 class="my-title form-signin-heading">Авторизация</h2>
        <label for="login" class="sr-only">login</label>
        <input name ="login" type="text" id="login" class="form-control" placeholder="логин" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input name="password" type="password" id="password" class="form-control" placeholder="пароль" required>
        <span class="error-title">${error}</span>
        <span class="logged-title">${message}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
        <a class="my-title form-signin-heading" href="/registration">Регистрация</a>
    </form>

    <%--<form method ="post" action="<c:url value='/j_spring_security_check' />" class="form-signin">--%>
        <%--<h2 class="my-title form-signin-heading">Авторизация</h2>--%>
        <%--<label for="login" class="sr-only">login</label>--%>
        <%--<input name ="login" type="text" id="login" class="form-control" placeholder="логин" required autofocus>--%>
        <%--<label for="password" class="sr-only">Password</label>--%>
        <%--<input name="password" type="password" id="password" class="form-control" placeholder="пароль" required>--%>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>--%>
    <%--</form>--%>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>