<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String WsUrl = getServletContext().getInitParameter("WsUrl"); %>
<html>
<head>
    <title>Главная страница</title>
    <link rel="stylesheet" type="text/css" href="content/styles/site.css">

    <script type="text/javascript" src="scripts/chatroom.js"></script>

    <script type="text/javascript">
        var wsUri = '<%=WsUrl%>';
        var proxy = CreateProxy(wsUri);

        document.addEventListener("DOMContentLoaded", function(event) {
            console.log(document.getElementById('loginPanel'));
            proxy.initiate({
                loginPanel: document.getElementById('loginPanel'),
                msgPanel: document.getElementById('msgPanel'),
                txtMsg: document.getElementById('txtMsg'),
                txtLogin: document.getElementById('txtLogin'),
                msgContainer: document.getElementById('msgContainer')
            });
        });

    </script>
</head>
<body>
<h2>Приветствуем Вас на главной странице!</h2>
<% String name = (String) request.getSession().getAttribute("nameUser");%>
<h1>
    <%=name%>
</h1>
<form method="post" action="/main">

    <div id="container">

        <%--<div id="loginPanel" style="display: none">--%>
            <%--<div id="infoLabel">Type a name to join the room</div>--%>
            <%--<div style="padding: 10px;">--%>
                <%--<input id="txtLogin" type="text" class="loginInput"--%>
                       <%--onkeyup="proxy.login_keyup(event)" />--%>
                <%--<button type="button" class="loginInput" onclick="proxy.login()">Login</button>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div id="msgPanel">
            <div id="msgContainer" style="overflow: auto;"></div>
            <div id="msgController">

			<textarea id="txtMsg"
                      title="Enter to send message"
                      onkeyup="proxy.sendMessage_keyup(event)"
                      style="height: 20px; width: 100%"></textarea>

                <%--<button style="height: 30px; width: 100px" type="button"--%>
                        <%--onclick="proxy.logout()">Logout</button>--%>
                <input type="submit" value="выход" name="exit" onclick="proxy.logout()"/>
            </div>
        </div>

    </div>


</form>
</body>
</html>

<%--<!DOCTYPE html>--%>
<%--<% String WsUrl = getServletContext().getInitParameter("WsUrl"); %>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>Dashboard Template for Bootstrap</title>--%>

    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->--%>
    <%--<link href="/css/ie10-viewport-bug-workaround.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
    <%--<link href="css/dashboard.css" rel="stylesheet">--%>

    <%--<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->--%>
    <%--<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->--%>
    <%--<script src="/js/ie-emulation-modes-warning.js"></script>--%>

    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>

    <%--<link rel="stylesheet" type="text/css" href="css/site.css">--%>
    <%--<script type="text/javascript" src="chatroom.js"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--var wsUri = '<%=WsUrl%>';--%>
        <%--var proxy = CreateProxy(wsUri);--%>

        <%--document.addEventListener("DOMContentLoaded", function(event) {--%>
            <%--console.log(document.getElementById('loginPanel'));--%>
            <%--proxy.initiate({--%>
                <%--loginPanel: document.getElementById('loginPanel'),--%>
                <%--msgPanel: document.getElementById('msgPanel'),--%>
                <%--txtMsg: document.getElementById('txtMsg'),--%>
                <%--txtLogin: document.getElementById('txtLogin'),--%>
                <%--msgContainer: document.getElementById('msgContainer')--%>
            <%--});--%>
        <%--});--%>

    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>

<%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">--%>
                <%--<span class="sr-only">Toggle navigation</span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <%--<a class="navbar-brand" href="#">Школа иностранных языков</a>--%>
        <%--</div>--%>
        <%--<div id="navbar" class="navbar-collapse collapse">--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li><form method="post" action="/main">--%>
                    <%--<input class="btn btn-primary" type="submit" value="выход" name="exit"/>--%>
                <%--</form></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>

<%--<div class="container-fluid">--%>
    <%--<div class="row">--%>
        <%--<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">--%>
            <%--<h1 class="page-header">Chatroom</h1>--%>
            <%--&lt;%&ndash;<h2>Приветствуем Вас на главной странице!</h2>&ndash;%&gt;--%>
            <%--<% String name = (String) request.getSession().getAttribute("nameUser");%>--%>
            <%--<h1>--%>
            <%--<%=name%>--%>
            <%--</h1>--%>

            <%--<div id="msgContainer"></div>--%>
            <%--<div id="msgController">--%>

            <%--<textarea id="txtMsg"--%>
                      <%--title="Enter to send message"--%>
                      <%--onkeyup="proxy.sendMessage_keyup(event)"--%>
                      <%--style="height: 20px; width: 100%"></textarea>--%>
        <%--</div>--%>


        <%--&lt;%&ndash;<div id="msgController">&ndash;%&gt;--%>

        <%--&lt;%&ndash;&lt;%&ndash;<button style="height: 30px; width: 100px" type="button"&ndash;%&gt;&ndash;%&gt;--%>
        <%--&lt;%&ndash;&lt;%&ndash;onclick="proxy.logout()">Logout</button>&ndash;%&gt;&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--</div>--%>

<%--</div>--%>
<%--&lt;%&ndash;<div id="msgContainer"></div>&ndash;%&gt;--%>


<%--<!-- Bootstrap core JavaScript--%>
<%--================================================== -->--%>
<%--<!-- Placed at the end of the document so the pages load faster -->--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
<%--<script>window.jQuery || document.write('<script src="js/vendor/jquery.min.js"><\/script>')</script>--%>
<%--<script src="/js/bootstrap.min.js"></script>--%>
<%--<!-- Just to make our placeholder images work. Don't actually copy the next line! -->--%>
<%--<script src="/js/vendor/holder.min.js"></script>--%>
<%--<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->--%>
<%--<script src="/js/ie10-viewport-bug-workaround.js"></script>--%>
<%--</body>--%>
<%--</html>--%>

