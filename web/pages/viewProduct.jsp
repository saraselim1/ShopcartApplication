<%-- 
    Document   : viewProduct
    Created on : Mar 13, 2017, 3:40:35 PM
    Author     : Sara Selim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Product Details</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Bootstrap styles -->
        <link href="../assets/css/bootstrap.css" rel="stylesheet"/>
        <!-- Customize styles -->
        <link href="style.css" rel="stylesheet"/>
        <!-- font awesome styles -->
        <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <!--[if IE 7]>
                <link href="css/font-awesome-ie7.min.css" rel="stylesheet">
        <![endif]-->

        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Favicons -->
        <link rel="shortcut icon" href="../assets/ico/favicon.ico">
       
    </head>
    <body>
        
        <jsp:include page="Header.jsp" ></jsp:include>
        
        <div class="container">

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
                                                <input type="password" class="span2" id="inputPassword" placeholder="Password">
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


                </div>
                <div class="span10">
                   	
                    <div class="well well-small">
                        <div class="row-fluid">
                            <div class="span5">
                                <div id="myCarousel" class="carousel slide cntr">
                                    <div class="carousel-inner">
                                        <div class="item active">
                                            <a href="#"> <img src="${pageContext.request.contextPath}/assets/img/${imgMaster}" alt="" style="width:100%"></a>
                                        </div>
                                        <div class="item">
                                            <a href="#"> <img src="${pageContext.request.contextPath}/assets/img/${img1}" alt="" style="width:100%"></a>
                                        </div>
                                        <div class="item">
                                            <a href="#"> <img src="${pageContext.request.contextPath}/assets/img/${img2}" alt="" style="width:100%"></a>
                                        </div>
                                        <div class="item">
                                            <a href="#"> <img src="${pageContext.request.contextPath}/assets/img/${img3}" alt="" style="width:100%"></a>
                                        </div>
                                    </div>
                                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                                    <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                                </div>
                            </div>
                            <div class="span7">
                                <h3>${requestScope.name}</h3>
                                <hr class="soft"/>

                                <form class="form-horizontal qtyFrm">
                                    <div class="control-group">
                                        <label class="control-label"><span>$ ${requestScope.price}</span></label>
                                        <div class="controls">
                                            <input type="number" class="span6" placeholder="Qty.">
                                        </div>
                                    </div>

                                    <h4>${requestScope.quantity} items in stock</h4>
                                    <p>
                                        ${requestScope.description}
                                    <p>
                                        <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span> Add to cart</button>
                                </form>
                            </div>
                        </div>
                        <hr class="softn clr"/>
                        
                        <div id="myTabContent" class="tab-content tabWrapper">
                            <div class="tab-pane fade" id="profile">
                                <div class="row-fluid">	  
                                    
                                    <div class="span4 alignR">
                                        <form class="form-horizontal qtyFrm">
                                            <label class="checkbox">
                                                
                                            </label><br>
                                            <div class="btn-group">
                                                <a href="product_details.html" class="defaultBtn"><span class=" icon-shopping-cart"></span> Add to cart</a>
                                                <a href="product_details.html" class="shopBtn">VIEW</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <hr class="soften"/>
                                <div class="row-fluid">	  
                                    <div class="span2">
                                        <img src="../assets/img/d.jpg" alt="">
                                    </div>
                                    <div class="span6">
                                        <h5>Product Name </h5>
                                        <p>
                                            Nowadays the lingerie industry is one of the most successful business spheres.
                                            We always stay in touch with the latest fashion tendencies - 
                                            that is why our goods are so popular..
                                        </p>
                                    </div>
                                    <div class="span4 alignR">
                                        <form class="form-horizontal qtyFrm">
                                            <h3> $140.00</h3>
                                            <label class="checkbox">
                                                <input type="checkbox">  Adds product to compair
                                            </label><br>
                                            <div class="btn-group">
                                                <a href="product_details.html" class="defaultBtn"><span class=" icon-shopping-cart"></span> Add to cart</a>
                                                <a href="product_details.html" class="shopBtn">VIEW</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <hr class="soften"/>

                            </div>
                        </div>

                    </div>
                </div>
            </div> <!-- Body wrapper -->
        </div><!-- /container -->

        <a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="../assets/js/jquery.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/jquery.easing-1.3.min.js"></script>
        <script src="../assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="../assets/js/shop.js"></script>
    </body>
</html>