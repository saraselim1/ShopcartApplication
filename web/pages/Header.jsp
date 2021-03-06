<!DOCTYPE html>
<html lang="en">
    <header>
        <meta charset="utf-8">
        <title>Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/shop.js"></script>
        <link rel="${pageContext.request.contextPath}/shortcut icon" href="${pageContext.request.contextPath}/assets/ico/favicon.ico"/>

        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %></%@taglib>
        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %></%@taglib>
        <%@page contentType="text/html" pageEncoding="UTF-8"%></%@page>
        <!--End Sara-->
        <script>
            $(document).ready(function () {
                $('#searchArea').hide();
                var url = window.location.href;
                if (url.search('home.jsp') > 0) {
                    $('#searchArea').show();
                } else {
                    $('#searchArea').hide();
                }
            });
            function requestProductListByName() {
                name = $('#searchText').val();
                myList = JSON.stringify("{categoryName:'" + name + "',date:'" + new Date().toString() + "'}");
                $.ajax({url: '../SerchProductByNameServlet?myProductName=' + name + '&date=' + new Date().toString(), type: 'Post', contentType: myList, datatype: 'json', success: function (product) {
                        $("#productListDiv").html("");
                        $("#productListDiv").append("<h3>Our Products </h3>");
                        if (product.categoryId !== 0) {
                            $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\"><img src=\"../assets/img/" + product.img + "\" alt=\"\"></a><div class=\"caption cntr\"><p>" + product.name + "</p><p><strong>" + product.price + "</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");
                        } else {
                            $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\">No Such Product</div>");
                        }
                    }});
            }
            function getUserCookie() {
                $.ajax({
                    url: "Home?date" + new Date(),
                    type: 'GET',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data, textStatus, jqXHR) {
                    }
                });

            }
        </script>
    </header>
    <body >
        <!-- Upper Header Section -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">
                        <a class="active" href="${pageContext.request.contextPath}/pages/home.jsp"> <span class="icon-home"></span> Home</a> 
                        <c:if test="${sessionScope.user == null}" >
                            <a href="${pageContext.request.contextPath}/UserAdd"><span class="icon-edit"></span> Free Register </a>
                        </c:if>
                        <c:if test="${sessionScope.user != null}" >
                            <a href="${pageContext.request.contextPath}/ViewProfileServlet"><span class="icon-user"></span> My Account</a>
                            <a href="${pageContext.request.contextPath}/GettingAllProductsInCart"><span class="icon-shopping-cart"></span>
                                Cart items </a>
                            <a href="${pageContext.request.contextPath}/UserOrders"><span class="icon-shopping-cart"></span> Orders </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="control-group">
            <label id="message" class="control-label" var="msg" valaue="${msg}" style="color:red"></label>
        </div>
        <div class="container">
            <header id="header">
                <div class="row">
                    <div class="span4">
                        <h1>
                            <a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> 
                                <img src="${pageContext.request.contextPath}/assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
                            </a>
                        </h1> 
                    </div>
                </div>
            </header>
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                        <ul class="nav">
                            <li class="active"><a href="${pageContext.request.contextPath}/pages/home.jsp">Home	</a></li>
                        </ul>
                        
                        <ul class="nav">
                            <c:if test="${requestScope.msg != null }">
                                <li>${requestScope.msg}</li>
                            </c:if>
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
                                    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="icon-lock"></span> Login <b class="caret"></b></a>
                                    <div class="dropdown-menu">
                                        <form method="post" action="${pageContext.request.contextPath}/User" class="form-horizontal loginFrm">
                                            <div class="control-group">
                                                <input type="text" class="span2" id="inputEmail" name="name" placeholder="Email">
                                            </div>
                                            <div class="control-group">
                                                <input type="password" class="span2" id="inputPassword"  name="password" placeholder="Password">
                                            </div>
                                            <div class="control-group">
                                                <label class="checkbox">
                                                    <input name="remmberMe" type="checkbox"> Remember me
                                                </label>
                                                <button type="submit" class="shopBtn btn-block">Sign in</button>
                                            </div>
                                        </form>
                                    </div>
                                </li>
                            </ul>    
                        </c:if>
                        <c:if test="${sessionScope.user != null}" >
                            <ul class="nav pull-right">
                                <li class="dropdown"> <a href="${pageContext.request.contextPath}/logoutServlet">
                                        <span class="icon-lock"></span> logout </a>
                                </li>
                            </ul>
                        </c:if>
                    </div>
                </div>
            </div>
