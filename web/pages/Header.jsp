<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.easing-1.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/shop.js"></script>
        <link rel="${pageContext.request.contextPath}/shortcut icon" href="assets/ico/favicon.ico">
        
        <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <script>
            $(document).ready(function () {
                $("#signInBtn").click(function () {
                    var userNameValue = $("#inputEmail").val();
                    var passwordValue = $("#inputPassword").val();
                    var jsonData = {userName: userNameValue, pass: passwordValue};
                    $.ajax({url: 'SignInSevlet?data=' new Date,
                                type: 'POST',
                        contentType: 'application/json',
                        data: jsonData.toString(),
                        dataType: 'json',
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                        }
                    })
                });
            });
        </script>
        <!--End Sara-->
    </head>
    <body>
        <!-- Upper Header Section -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">
                        <a class="active" href="index.html"> <span class="icon-home"></span> Home</a> 
                        <a href="#"><span class="icon-user"></span> My Account</a>
                        <a href="register.html"><span class="icon-edit"></span> Free Register </a>
                        <a href="GettingAllProductsInCart"><span class="icon-shopping-cart"></span> 2 Item(s) - <span class="badge badge-warning"> $448.42</span></a>
                        <a href="UserOrders"><span class="icon-shopping-cart"></span> Orders </a>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br>
        <div class="container">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                        <div class="nav-collapse">
                            <form action="#" class="navbar-search pull-left">
                                <input type="text" placeholder="Search" class="search-query span2"> </form>
                            <ul class="nav pull-right">
                                <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                        <span class="icon-lock"></span> Login <b class="caret"></b></a>
                                    <div class="dropdown-menu">
                                        <form class="form-horizontal loginFrm">
                                            <div class="control-group">
                                                <input type="text" class="span2" id="inputEmail" placeholder="UserName"> </div>
                                            <div class="control-group">
                                                <input type="password" class="span2" id="inputPassword" placeholder="Password"> </div>
                                            <div class="control-group">
                                                <label class="checkbox">
                                                    <input type="checkbox"> Remember me </label>
                                                <button id="signInBtn" class="shopBtn btn-block">Sign in</button>
                                        </form>
                                    </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br>