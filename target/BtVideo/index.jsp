<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>list</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet"  type="text/css" href="css/easyhelper.min.css">

    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="images/icon.png">
    <link rel="shortcut icon" href="images/favicon.ico">

    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/nprogress.js"></script>
    <script src="js/jquery.lazyload.min.js"></script>
    <style>

        .page {
            text-align: center;
            top: 200px;
        }
    </style>

</head>

<body class="user-select">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container" >
            <div class="navbar-header  pull-left">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar" aria-expanded="false"> <span class="sr-only"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <h1 class="logo hvr-bounce-in"><a href="VideoServlet" title="小博客"><img src="images/logo.png" alt="小博客"></a></h1>
            </div>
            <div class="widget widget_search pull-right" style="position: absolute; right: 20px;top: 5px">
                <form class="navbar-form" action="VideoServlet" method="post">
                    <div class="input-group">
                        <input  type="hidden" name="sign" value="search"/>
                        <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入电影名" maxlength="15" autocomplete="off" value="<c:out value="${keyword}" ></c:out>">
                        <span class="input-group-btn"><input class="btn btn-default btn-search" name="searchBtn" type="submit" value="搜索"/> </span>
                    </div>
                </form>
            </div>
        </div>
    </nav>
</header>



<section class="container">
    <div class="page" id="page-3"></div>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.transit.min.js"></script>
    <script src="js/es6-shim.min.js"></script>
    <script src="js/easyhelper.min.js"></script>











    <div class="content-wrap" >
        <div class="content">
            <div class="title "><a  href="VideoServlet">
                <h3 style="line-height: 1.3">主页</h3></a>
            </div>




            <c:forEach items="${movieList}" var="movie">
            <article class="excerpt excerpt-1  "   style="width: 100%;position: relative;">
                <a class="focus" href="
                           <c:out value="${movie.thunder}" ></c:out>"  target="_self" ><img class="thumb" data-original="<c:out value="${movie.imageUrl}" ></c:out>" src="
                            <c:out value="${movie.imageUrl}" ></c:out>"   style="display: inline;"></a>
                <div  style="position: absolute;left: 150px;right: 20px">
                    <header>
                        <a class="cat" href="javascript:void(0);" title="年份" >
                            <c:out value="${movie.showYear}" ></c:out><i></i>
                        </a>
                        <h2><a href="javascript:void(0);" title="电影名" target="	_blank" >
                            <c:out value="${movie.movieName}" ></c:out>
                        </a></h2>
                    </header>
                    <p class="meta">
                        <time class="time"><i class="glyphicon glyphicon-time"></i>
                            <c:out value="${movie.updateTime}" ></c:out>
                        </time> &nbsp;&nbsp;
                        <span class="type"><i class="glyphicon glyphicon-globe"></i>
                             <c:out value="${movie.movieLanguage}" ></c:out>
                        </span> &nbsp;&nbsp;
                        <span class="type"><i class="glyphicon glyphicon-tasks"></i>
                            <c:out value="${movie.type}" ></c:out>
                        </span> &nbsp;&nbsp;
                        <span class="type"><i class="glyphicon glyphicon-cd"></i>清晰度:
                            <c:out value="${movie.sharpness}" ></c:out>
                        </span> &nbsp;&nbsp;
                        <span class="views"><i class="glyphicon glyphicon-star"></i>评分:
                            <c:out value="${movie.rate}" ></c:out>
                        </span> &nbsp;&nbsp;
                    </p>
                    <p class="note"><span class="h4">简介:</span>
                        <c:out value="${movie.intro}" ></c:out>
                    </p>
                </div>
            </article>
            </c:forEach>
        </div>

    </div>

</section>




<script src="js/jquery.min.js"></script>
<script src="js/jquery.transit.min.js"></script>
<script src="js/es6-shim.min.js"></script>
<script src="js/easyhelper.min.js"></script>


<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.ias.js"></script>
<script src="js/scripts.js"></script>
<script>
    // 本地模拟的内容生成函数
    // var $content = $( ".content" );
    // function createContent ( i, index ) {
    //     $content.eq( index ).empty().html( ('<li>' + i + '</li>').repeat(10) );
    // }

    // 调用分页功能 [ 基础版 ]
    Helper.ui.page("#page-3", {
        total:<c:out value="${countMovie}" ></c:out>,
        pageSize: 10,
        showTotal: true,
        showTo: true,
        currentPage: <c:out value="${page}" ></c:out>,
        change: function ( i ) {
            // createContent( i, 2 );
        }
    });
    $('.helper-page-wrapper').on('click','i',function () {
        location.href = "VideoServlet?page="+($(this).index()+1);
    });

</script>



</body>
</html>
