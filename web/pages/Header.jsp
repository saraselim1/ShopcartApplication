<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.9.1.min.js"></script>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.easing-1.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/shop.js"></script>
        <link rel="${pageContext.request.contextPath}/shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!--End Sara-->

        <script>
            /*$(document).ready(function () {
                $('#searchArea').hide();
                var url = window.location.href;
                console.log(url);
                if (url.search('home.jsp') > 0) {
                    $('#searchArea').show();
                } else {
                    $('#searchArea').hide();
                }
            });*/
            function requestProductListByName() {
                //console.log(name);
                name = $('#searchText').val();
                console.log(name);
                myList = JSON.stringify("{categoryName:'" + name + "',date:'" + new Date().toString() + "'}");
                $.ajax({url: '../SerchProductByNameServlet?myProductName=' + name + '&date=' + new Date().toString(), type: 'Post', contentType: myList, datatype: 'json', success: function (product) {
                        console.log(product);
                        $("#productListDiv").html("");
                        $("#productListDiv").append("<h3>Our Products </h3>");
                        if (product.categoryId !== 0) {
                            $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\"><img src=\"../assets/img/" + product.img + "\" alt=\"\"></a><div class=\"caption cntr\"><p>" + product.name + "</p><p><strong>" + product.price + "</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");
                        } else {
                            $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\">No Such Product</div>");
                        }
                    }});
            }
        </script>

    </head>
    <body>
        <!-- Upper Header Section -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">
                        <a class="active" href="Home"> <span class="icon-home"></span> Home</a> 
                        <c:if test="${sessionScope.user == null}" >
                            <a href="UserAdd"><span class="icon-edit"></span> Free Register </a>
                        </c:if>
                        <c:if test="${sessionScope.user != null}" >
                            <a href="#"><span class="icon-user"></span> My Account</a>
                            <a href="GettingAllProductsInCart"><span class="icon-shopping-cart"></span>
                                ${fn:length(sessionScope.user.cart.product)} items </a>
                            <a href="UserOrders"><span class="icon-shopping-cart"></span> Orders </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <header id="header">
                <div class="row">
                    <div class="span4">
                        <h1>
                            <a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> 
                                <img src="${pageContext.request.contextPath}/assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
                            </a>
                        </h1> </div>
                </div>
            </header>
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                            <ul class="nav">
                                <li class="active"><a href="home.jsp">Home	</a></li>
                            </ul>
                            <div  id="searchArea">
                                <form action="#" class="navbar-search pull-left">
                                    <input id="searchText" type="text" placeholder="Search" class="search-query span2">
                                    <button type="button" onclick="requestProductListByName()" class="add-on"><i class="icon-search"></i></button>
                                </form>
                            </div>
                            <c:if test="${sessionScope.user == null}" >
                                <ul class="nav pull-right">
                                    <li class="dropdown"> 
                                        <a data-toggle="dropdown" class="dropdown-toggle" href="#loginForm">
                                            <span class="icon-lock"></span> Login <b class="caret"></b></a>
                                        <div id="loginForm" class="dropdown-menu">
                                            <form method="POST" action="User" class="form-horizontal loginFrm">
                                                <div class="control-group">
                                                    <input type="text" class="span2" id="inputEmail" name="name" placeholder="UserName"> </div>
                                                <div class="control-group">
                                                    <input type="password" class="span2" id="inputPassword" name="password" placeholder="Password"> </div>
                                                <div class="control-group">
                                                    <label class="checkbox">
                                                        <input type="checkbox"> Remember me </label>
                                                    <button id="signInBtn" type="submit" class="shopBtn btn-block">Sign in</button>
                                                </div>
                                            </form>
                                        </div>
                                    </li>
                                </ul>
                            </c:if>
                            <c:if test="${sessionScope.user != null}" >
                                <ul class="nav pull-right">
                                    <li class="dropdown"> <a href="">
                                            <span class="icon-lock"></span> logout </a>

                                        </div>
                                    </li>
                                </ul>
                            </c:if>
                        </div>
                    </div>
                </div>
            
<br><br><br><br>