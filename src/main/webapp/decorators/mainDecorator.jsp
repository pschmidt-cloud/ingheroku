<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="org.springframework.security.context.SecurityContext" %>
<%@ page import="org.springframework.security.userdetails.UserDetails" %>
<%@ page import="org.springframework.security.context.SecurityContextHolder" %>

<%!
    private String buildversion = "todo";

%>
<%
    final SecurityContext context = SecurityContextHolder.getContext();
    UserDetails userDetails = null;

    if (context != null) {
        if (context.getAuthentication() != null) {
            userDetails = (UserDetails) context.getAuthentication().getPrincipal();
        }
    }

    String path = request.getPathInfo();
    String query_string = request.getQueryString();
%>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Expires" content="-1"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>

    <title>
        <decorator:title default="{ Unknown Page - shouldn't see this, since pages should define title }"/>
    </title>

    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/core.css">
    <link rel="stylesheet" type="text/css" href="css/icg.css">
    <link rel="stylesheet" type="text/css" href="/css/demo_table.css">
    <link rel="shortcut icon" href="/img/favicon.png">
    <link rel="stylesheet" type="text/css" href="/css/jqueryui-1.8.20/themes/smoothness/jquery-ui.css">

    <script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.20.min.js"></script>
    <script type="text/javascript" src="/js/jquery.dataTables-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/icgutils.js"></script>
    <script type="text/javascript" src="/js/date.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <script type="text/javascript">
           $(function() {
		        hu_path = window.location.pathname;
	        	hu_query = window.location.search.substring(1);
	        	huv = hu_path.substring(hu_path.lastIndexOf('/')+1, hu_path.length);

	        	var current = '#bootstrap_' + huv;
	    	    $(current).addClass("active");
           });
    </script>

    <decorator:head/>
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
                        <li id="bootstrap_home"><a href="/home">Home</a></li>
                        <li class="dropdown" id="bootstrap_datatset_upload">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#bootstrap_datatset_upload">
                                Upload
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/dataset_upload">Upload Experiment Dataset</a></li>
                                <li><a href="#">Upload IPA cited Publication</a></li>
                            </ul>
                        </li>

                        <li class="dropdown" id="bootstrap_dataset_search">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#bootstrap_dataset_search">
                                Search
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/dataset_search">Search Experiment Dataset</a></li>
                                <li><a href="#">Search IPA cited Publication</a></li>
                            </ul>
                        </li>

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

    <div id="topgap" style="height: 1px"></div>

    <div id="contentWrapper">
        <br/>
        <br/>
        <decorator:body/>
    </div>
    <!--  end content -->

    <div id="footer">
        <center>
            &copy;2000-<%=java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)%> Ingenuity Systems, Inc. All
            rights reserved.
            <br/>
            Version: <%=buildversion%>
        </center>
    </div>
    <!--  end footer -->

</body>

</html>

