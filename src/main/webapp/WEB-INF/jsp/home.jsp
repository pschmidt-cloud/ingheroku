<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.context.SecurityContext" %>
<%@ page import="org.springframework.security.userdetails.UserDetails" %>
<%@ page import="org.springframework.security.context.SecurityContextHolder" %>

<!DOCTYPE html>

<html>
<head>
    <title>Ingenuity Heroku Skeleton WebApp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Expires" content="-1"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>

    <link rel="stylesheet" type="text/css" href="/css/core.css">
    <link rel="stylesheet" type="text/css" href="css/icg.css">
    <link rel="stylesheet" type="text/css" href="/css/demo_table.css">
    <link rel="shortcut icon" href="/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="/css/jqueryui-1.8.20/themes/smoothness/jquery-ui.css">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">

    <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.20.min.js"></script>
    <script type="text/javascript" src="/js/jquery.dataTables-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/icgutils.js"></script>
    <script type="text/javascript" src="/js/date.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <script type="text/javascript">
    </script>

</head>

<body>
<noscript>
    <div class="javascriptDisabledNotice">
        <strong>Javascript Disabled</strong> &mdash; Please enable javascript to use the application.
    </div>
</noscript>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">Ingenuity Heroku Skeleton Application</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>

                    <li class="dropdown" id="menu1">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
                            Options
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div id="content">
    <br /><br />
    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <h1>Hello, world!</h1>

        <p>This is a template for a simple marketing or informational
            website. It includes a large callout called the hero unit and three
            supporting pieces of content. Use it as a starting point to create
            something more unique.</p>
        <a class="btn btn-primary" data-toggle="modal" href="#myModal">Launch Modal</a>
    </div>

    <!-- Example row of columns -->
    <div class="row">
        <div class="span4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce
                dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                mollis euismod. Donec sed odio dui. </p>

            <p><a class="btn" href="#">View details »</a></p>
        </div>
        <div class="span4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce
                dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                mollis euismod. Donec sed odio dui. </p>

            <p><a class="btn" href="#">View details »</a></p>
        </div>
        <div class="span4">
            <h2>Heading</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
                in, egestas eget quam. Vestibulum id ligula porta felis euismod semper.
                Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                ut fermentum massa justo sit amet risus.</p>

            <p><a class="btn" href="#">View details »</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>© Company 2012</p>
    </footer>

    <div class="modal hide" id="myModal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h3>Modal header</h3>
        </div>
        <div class="modal-body">
            <p>One fine body</p>
        </div>
        <div class="modal-footer">
            <a href="#" class="btn" data-dismiss="modal">Close</a>
            <a href="#" class="btn btn-primary">Save changes</a>
        </div>
    </div>

</div>
</div>


</body>
</html>

