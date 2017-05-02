<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2017
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Ошибка ввода логина или пароля!</h2>--%>
<%--<form method="post" action="/loginerror">--%>
    <%--<input type="submit" value="назад" name="ago"/>--%>
<%--</form>--%>
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

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/main/webapp/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/main/webapp/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
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
                <li><form method="post" action="/loginerror">
                    <input class="btn btn-primary" type="submit" value="назад" name="ago"/>
                </form></li>
            </ul>
            <%--<form class="navbar-form navbar-right">--%>
            <%--<input type="text" class="form-control" placeholder="Search...">--%>
            <%--</form>--%>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <%--<div class="col-sm-3 col-md-2 sidebar">--%>
        <%--<ul class="nav nav-sidebar">--%>
        <%--<li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>--%>
        <%--<li><a href="#">Reports</a></li>--%>
        <%--<li><a href="#">Analytics</a></li>--%>
        <%--<li><a href="#">Export</a></li>--%>
        <%--</ul>--%>
        <%--<ul class="nav nav-sidebar">--%>
        <%--<li><a href="">Nav item</a></li>--%>
        <%--<li><a href="">Nav item again</a></li>--%>
        <%--<li><a href="">One more nav</a></li>--%>
        <%--<li><a href="">Another nav item</a></li>--%>
        <%--<li><a href="">More navigation</a></li>--%>
        <%--</ul>--%>
        <%--<ul class="nav nav-sidebar">--%>
        <%--<li><a href="">Nav item again</a></li>--%>
        <%--<li><a href="">One more nav</a></li>--%>
        <%--<li><a href="">Another nav item</a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Ошибка ввода логина или пароля!</h1>
            <%--<h2>Ошибка ввода логина или пароля!</h2>--%>
            <%--<% String name = (String) request.getSession().getAttribute("nameUser");%>--%>
            <%--<h1>--%>
                <%--<%=name%>--%>
            <%--</h1>--%>
            <%--<form method="post" action="/main">--%>
            <%--<input type="submit" value="выход" name="exit"/>--%>
            <%--</form>--%>


            <%--<div class="table-responsive">--%>
            <%--<table class="table table-striped">--%>
            <%--<thead>--%>
            <%--<tr>--%>
            <%--<th>Логин</th>--%>
            <%--<th>Имя</th>--%>
            <%--<th>Фамилия</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--&lt;%&ndash;<c:forEach items="${requestScope.users2}" var="user">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<td><c:out value="${user.idUser}"></c:out></td>&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><c:out value="${user.login}"></c:out></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><c:out value="${user.name}"></c:out></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<td><c:out value="${user.surname}"></c:out></td>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
            <%--</tbody>--%>
            <%--</table>--%>
            <%--</div>--%>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/vendor/jquery.min.js"><\/script>')</script>
<script src="/main/webapp/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>