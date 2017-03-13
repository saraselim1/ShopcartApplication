<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Twitter Bootstrap shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Start Sara -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <!--End Sara-->
    </head>
    <body>
        <!-- Upper Header Section -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">
                        <a class="active" href="index.html"> <span class="icon-home"></span> Home</a> <a href="#"><span class="icon-user"></span> My Account</a> <a href="register.html"><span class="icon-edit"></span> Free Register </a> <a href="cart.html"><span class="icon-shopping-cart"></span> 2 Item(s) - <span class="badge badge-warning"> $448.42</span></a>

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
                                <li class="dropdown"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="icon-lock"></span> Login <b class="caret"></b></a>
                                    <div class="dropdown-menu">
                                        <form class="form-horizontal loginFrm">
                                            <div class="control-group">
                                                <input type="text" class="span2" id="inputEmail" placeholder="Email"> </div>
                                            <div class="control-group">
                                                <input type="password" class="span2" id="inputPassword" placeholder="Password"> </div>
                                            <div class="control-group">
                                                <label class="checkbox">
                                                    <input type="checkbox"> Remember me </label>
                                                <button type="submit" class="shopBtn btn-block">Sign in</button>
                                            </div>
                                        </form>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>