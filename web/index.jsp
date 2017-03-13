<%-- 
    Document   : index.jsp
    Created on : Mar 13, 2017, 3:37:11 PM
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="assets/css/bootstrap.css" rel="stylesheet"/>
        <link href="style.css" rel="stylesheet"/>
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="jquery-1.9.1.min.js"></script>
        <script>
         
            function sendRequest(){
                //$.ajax({url:'CategoryListServlet',type:'GET',contentType:'text/html',new Date().toString(),datatype:'text',success:function(data){console.log(data);}});
            
            }
             function startRequest(){
                $.ajax({url:'GetAllCategorysServlet',type:'Post',contentType:'application/json',data:new Date().toString(),datatype:'json',success:function(data){console.log(data);console.log(data.length); $("#result").html("");for(i=0;i<data.length;i++){ $("#result").append("<li><a href=\"products.html\"><span class=\"icon-chevron-right\"></span>"+data[i].name+"</a></li>");}}});
                                                                                                                                  
            }
        </script>
    </head>
<body onload="setInterval('startRequest()',5000)">
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul id ="result" class="nav nav-list">
		<!--<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Watches</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fine Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Engagement & Wedding</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Men's Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Vintage & Antique</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Diamonds </a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Beads</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
		--><li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
	</ul>
</div>
</div>
</div>
</body>
</html>
