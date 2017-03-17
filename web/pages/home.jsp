<%-- 
    Document   : home
    Created on : Mar 13, 2017, 3:40:13 PM
    Author     : Sara Selim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.9.1.min.js"></script>
        <script>
           
            var category;
             function requestCategoryList(){
                $.ajax({url:'../GetAllCategorysServlet',type:'Post',contentType:'application/json',data:new Date().toString(),datatype:'json',success:function(data){console.log(data);console.log(data.length); $("#result").html("");for(i=0;i<data.length;i++){ $("#result").append("<li><a href=\"#\" id=\""+data[i].name+"\" onclick=\"requestProductListByCategory("+'id'+");\"><span class=\"icon-chevron-right\"></span>"+data[i].name+"</a></li>");}$("#result").append("<li style=\"border:0\"> &nbsp;</li><li> <a class=\"totalInCart\" href=\"#\"><strong>Total Amount  <span class=\"badge badge-warning pull-right\" style=\"line-height:18px;\">$448.42</span></strong></a></li>");}});
            }
            function requestProductList(){
                $.ajax({url:'../GetAllProductsServlet',type:'Post',contentType:'application/json',data:new Date().toString(),datatype:'json',success:function(product){console.log(product);console.log(product.length); $("#productListDiv").html("");$("#productListDiv").append("<h3>Our Products </h3>"); for(i=0;i<product.length;i++){ $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" name=\""+product[i].name+"\" onclick=\"requestProductDetails("+'name'+");\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" name=\""+product[i].name+"\" onclick=\"requestProductDetails("+'name'+");\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\" name=\""+product[i].name+"\" onclick=\"requestProductDetails("+'name'+");\"><img src=\"../assets/img/"+product[i].imgMaster+"\" alt=\"\"></a><div class=\"caption cntr\"><p>"+product[i].name+"</p><p><strong>"+product[i].price+"</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");}}});
                            
            }
            function requestProductListByCategory(name){
                console.log(name);
                myData=JSON.stringify("{categoryName:'"+name+"',date:'"+new Date().toString()+"'}");
                $.ajax({url:'../SearchForProductByCategoryServlet?categoryName='+name+'&date='+new Date().toString(),type:'Post',contentType:myData,datatype:'json',success:function(product){console.log(product);console.log(product.length); $("#productListDiv").html("");$("#productListDiv").append("<h3>Our Products </h3>"); for(i=0;i<product.length;i++){ $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\"><img src=\"../assets/img/"+product[i].img+"\" alt=\"\"></a><div class=\"caption cntr\"><p>"+product[i].name+"</p><p><strong>"+product[i].price+"</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");}}});
                            
                                                                                                                                                                                                                                                                                                                                                        
            }
            function requestProductListByName(){
                //console.log(name);
                name = $('#searchText').val();
                console.log(name);
                myList=JSON.stringify("{categoryName:'"+name+"',date:'"+new Date().toString()+"'}");
                $.ajax({url:'../SerchProductByNameServlet?myProductName='+name+'&date='+new Date().toString(),type:'Post',contentType:myList,datatype:'json',success:function(product){console.log(product);$("#productListDiv").html("");$("#productListDiv").append("<h3>Our Products </h3>");if(product.categoryId!==0){$("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\"><img src=\"../assets/img/"+product.img+"\" alt=\"\"></a><div class=\"caption cntr\"><p>"+product.name+"</p><p><strong>"+product.price+"</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");}else{$("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\">No Such Product</div>");}}});
            }
            function requestProductDetails(sentName){
                console.log(sentName);
                //myNewList=JSON.stringify("{productName:'"+sentName+"',date:'"+new Date().toString()+"'}");
                //$.ajax({url:'../GetProductDetailsServ?productName='+sentName+'&date='+new Date().toString(),type:'POST',contentType:myNewList,datatype:'json',success:function(product){console.log(product);$(".row").html(product)}});
               // $.post('../GetProductDetailsServ', {'productName': 'name'});
               $('#myText').val(sentName);
               $('#submitBtn').click();
               
            }
            function loadHome(){
                
                requestProductList();
                requestCategoryList();
                
            }
        </script>
    </head>
<body onload="loadHome();">
<!--static part start-->
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
				<a href="home.jsp"> <span class="icon-home"></span> Home</a> 
				<a href="#"><span class="icon-user"></span> My Account</a> 
				<a href="#"><span class="icon-edit"></span> Free Register </a> 
				<!--<a href="contact.html"><span class="icon-envelope"></span> Contact us</a>-->
                                <a href="viewCart"><span class="icon-shopping-cart"></span> 2 Item(s) - <span class="badge badge-warning"> $448.42</span></a>
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
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> 
		<img src="../assets/img/logo-bootstrap-shoping-cart.png" alt="Shopping Online">
	</a>
	</h1>
	</div>
	<div class="span4">
	<div class="offerNoteWrapper">
    <!-- hereeeeeeeeee ---------------------------------->
            <form hidden method="Post" action="${pageContext.request.contextPath}/GetProductDetailsServ">
                <input hidden id="myText" type="text" name="productName" value="">
                <input hidden id="submitBtn" type='submit' />
            </form>
        </div>
	</div>
	<div class="span4 alignR">
	
	</div>
</div>
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
			  <li class="active"><a href="home.jsp">Home	</a></li>
			</ul>
			<form action="#" class="navbar-search pull-left">
			  <input id="searchText" type="text" placeholder="Search" class="search-query span2">
                          <button type="button" onclick="requestProductListByName()" class="add-on"><i class="icon-search"></i></button>
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


<!--static part --> 


<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul id ="result" class="nav nav-list">
		
	</ul>
</div>
</div>
<!-- new products -->
<div class="span9">
	<div id="productListDiv" class="well well-small">
	<!--<h3>Our Products </h3>-->
		<!--<div class="row-fluid">
		  <ul class="thumbnails">
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="../assets/img/a.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Manicure & Pedicure</p>
					<p><strong> $22.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
					<div class="actionList">
						<a class="pull-left" href="#">Add to Wish List </a> 
						<a class="pull-left" href="#"> Add to Compare </a>
					</div> 
					<br class="clr">
				</div>
			  </div>
			</li>
		  </ul>
		</div>-->
            </div>
	</div>
</div>
  

<!-- end products -->
</body>
</html>
