<%-- 
    Document   : signUp
    Created on : Mar 13, 2017, 3:41:16 PM
    Author     : Sara Selim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
    </head>
    <body>
        <!-- 
                Upper Header Section 
        -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">
                        <div class="pull-left socialNw">
                            <a href="#"><span class="icon-twitter"></span></a>
                            <a href="#"><span class="icon-facebook"></span></a>
                            <a href="#"><span class="icon-youtube"></span></a>
                            <a href="#"><span class="icon-tumblr"></span></a>
                        </div>
                        <a href="index.html"> <span class="icon-home"></span> Home</a> 
                        <a href="#"><span class="icon-user"></span> My Account</a> 
                        <a class="active" href="register.html"><span class="icon-edit"></span> Free Register </a> 
                        <a href="contact.html"><span class="icon-envelope"></span> Contact us</a>
                        <a href="cart.html"><span class="icon-shopping-cart"></span> 2 Item(s) - <span class="badge badge-warning"> $448.42</span></a>
                    </div>
                </div>
            </div>
        </div>

        <!--
        Lower Header Section 
        -->
        <div class="container">
            <div id="gototop"> </div>
            <header id="header">
                
            </header>

            <!--
            Navigation Bar Section 
            -->
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                        <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <div class="nav-collapse">
                            <ul class="nav">
                                <li class=""><a href="index.html">Home	</a></li>
                                <li class=""><a href="list-view.html">List View</a></li>
                                <li class=""><a href="grid-view.html">Grid View</a></li>
                                <li class=""><a href="three-col.html">Three Column</a></li>
                                <li class=""><a href="four-col.html">Four Column</a></li>
                                <li class=""><a href="general.html">General Content</a></li>
                            </ul>
                            <form action="#" class="navbar-search pull-left">
                                <input type="text" placeholder="Search" class="search-query span2">
                            </form>
                            <ul class="nav pull-right">
                                <li class="dropdown">
                                    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="icon-lock"></span> Login <b class="caret"></b></a>
                                    <div class="dropdown-menu">
                                        <form class="form-horizontal loginFrm">
                                            <div class="control-group">
                                                <input type="text" class="span2" id="inputEmail" placeholder="Email">
                                            </div>
                                            <div class="control-group">
                                                <input type="password" class="span2" placeholder="Password">
                                            </div>
                                            <div class="control-group">
                                                <label class="checkbox">
                                                    <input type="checkbox"> Remember me
                                                </label>
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
            <!-- 
            Body Section 
            -->
            <div class="row">
                <div id="sidebar" class="span3">
                    <div class="well well-small">
                        <ul class="nav nav-list">
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Fashion</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Watches</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Fine Jewelry</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Fashion Jewelry</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Engagement & Wedding</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Men's Jewelry</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Vintage & Antique</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Loose Diamonds </a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>Loose Beads</a></li>
                            <li><a href="products.html"><span class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
                            <li style="border:0"> &nbsp;</li>
                            <li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
                        </ul>
                    </div>

                    
                   
                    <br>
                    <br>


                </div>
                <div class="span9">
                    <ul class="breadcrumb">
                        <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                        <li class="active">Registration</li>
                    </ul>
                    <h3> Registration</h3>	
                    <hr class="soft"/>
                    <div class="well">
                        <form action = "../UserAdd" method = "post" class="form-horizontal">
                            <h3>Your Personal Details</h3>

                            <div class="control-group">
                                <label class="control-label" for="inputFname">First name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="fName" id="inputFname" placeholder="First Name">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputLname">Last name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="lName" id="inputLname" placeholder="Last Name">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputLname">User name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="userName" id="inputUsername" placeholder="User Name">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputEmail">Email <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="email" placeholder="Email">
                                </div>
                            </div>	  
                            <div class="control-group">
                                <label class="control-label">Password <sup>*</sup></label>
                                <div class="controls">
                                    <input type="password" name="password" placeholder="Password">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Address <sup>*</sup></label>
                                <div class="controls">
                                    <textarea name="address"></textarea>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Gender <sup>*</sup></label>
                                <div class="controls">
                                    <select class="span1" name="gender">
                                        <option value="">-</option>
                                        <option value="1">Male&nbsp;&nbsp;</option>
                                        <option value="2">Female&nbsp;&nbsp;</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <input type="submit" name="submitAccount" value="Register" class="exclusive shopBtn">
                                </div>
                            </div>
                        </form>
                    </div>




                </div>
            </div>
            <!-- 
            Clients 
            -->
            
        </div><!-- /container -->

        
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.easing-1.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/shop.js"></script>
    </body>
</html>