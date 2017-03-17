<jsp:directive.include  file="Header.jsp"/>
<script>

    var category;
    function requestCategoryList() {
        $.ajax({url: '${pageContext.request.contextPath}/GetAllCategorysServlet', type: 'Post', contentType: 'application/json', data: new Date().toString(), datatype: 'json', success: function (data) {
                console.log(data);
                console.log(data.length);
                $("#result").html("");
                for (i = 0; i < data.length; i++) {
                    $("#result").append("<li><a href=\"#\" id=\"" + data[i].name + "\" onclick=\"requestProductListByCategory(" + 'id' + ");\"><span class=\"icon-chevron-right\"></span>" + data[i].name + "</a></li>");
                }
                $("#result").append("<li style=\"border:0\"> &nbsp;</li><li> <a class=\"totalInCart\" href=\"#\"><strong>Total Amount  <span class=\"badge badge-warning pull-right\" style=\"line-height:18px;\">$448.42</span></strong></a></li>");
            }});
    }
    function requestProductList() {
        $.ajax({url: '${pageContext.request.contextPath}/GetAllProductsServlet', type: 'Post', contentType: 'application/json', data: new Date().toString(), datatype: 'json', success: function (product) {
                console.log(product);
                console.log(product.length);
                $("#productListDiv").html("");
                $("#productListDiv").append("<h3>Our Products </h3>");
                for (i = 0; i < product.length; i++) {
                    $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" name=\"" + product[i].name + "\" onclick=\"requestProductDetails(" + 'name' + ");\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" name=\"" + product[i].name + "\" onclick=\"requestProductDetails(" + 'name' + ");\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\" name=\"" + product[i].name + "\" onclick=\"requestProductDetails(" + 'name' + ");\"><img src=\"../assets/img/" + product[i].imgMaster + "\" alt=\"\"></a><div class=\"caption cntr\"><p>" + product[i].name + "</p><p><strong>" + product[i].price + "</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");
                }
            }});

    }
    function requestProductListByCategory(name) {
        console.log(name);
        myData = JSON.stringify("{categoryName:'" + name + "',date:'" + new Date().toString() + "'}");
        $.ajax({url: '${pageContext.request.contextPath}/SearchForProductByCategoryServlet?categoryName=' + name + '&date=' + new Date().toString(), type: 'Post', contentType: myData, datatype: 'json', success: function (product) {
                console.log(product);
                console.log(product.length);
                $("#productListDiv").html("");
                $("#productListDiv").append("<h3>Our Products </h3>");
                for (i = 0; i < product.length; i++) {
                    $("#productListDiv").append("<div class=\"row-fluid\"><ul class=\"thumbnails\"><li class=\"span4\"><div class=\"thumbnail\"><a href=\"#\" class=\"overlay\"></a><a class=\"zoomTool\" href=\"#\" title=\"add to cart\"><span class=\"icon-search\"></span> QUICK VIEW</a><a href=\"#\"><img src=\"../assets/img/" + product[i].img + "\" alt=\"\"></a><div class=\"caption cntr\"><p>" + product[i].name + "</p><p><strong>" + product[i].price + "</strong></p><h4><a class=\"shopBtn\" href=\"#\" title=\"add to cart\"> Add to cart </a></h4><div class=\"actionList\"></div> <br class=\"clr\"></div></div></li></ul></div>");
                }
            }});


    }
    function requestProductDetails(sentName) {
        console.log(sentName);
        //myNewList=JSON.stringify("{productName:'"+sentName+"',date:'"+new Date().toString()+"'}");
        //$.ajax({url:'../GetProductDetailsServ?productName='+sentName+'&date='+new Date().toString(),type:'POST',contentType:myNewList,datatype:'json',success:function(product){console.log(product);$(".row").html(product)}});
        // $.post('../GetProductDetailsServ', {'productName': 'name'});
        $('#myText').val(sentName);
        $('#submitBtn').click();

    }
    function loadHome() {
        requestProductList();
        requestCategoryList();

    }
</script>
</head>
<body onload="loadHome();">
    <div class="container">
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
                </div>
            </div>
        </div>
        </div>
        <!-- end products -->
</body>
</html>
