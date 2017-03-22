<script>
    function addProductToCart(productIDValue, priceValue) {
        var newQuantity = $('#quantityToAdd').val();
        $.post("AddProductToCartServlet?date" + new Date(),
                {
                    quantity: newQuantity,
                    price: priceValue,
                    productId: productIDValue

                },
                function (data, status) {
                    alert(data);
                    $('#addbtn').hide();

                });
    }
</script>

<script src="${pageContext.request.contextPath}/assets/js/jquery.easing-1.3.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<jsp:include page="Header.jsp" ></jsp:include>
    <div class="container">
        <div class="row">
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
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">?</a>
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">?</a>
                        </div>
                    </div>
                    <div class="span7">
                        <h3>${requestScope.name}</h3>
                        <hr class="soft"/>

                        <div class="form-horizontal qtyFrm">
                            <div class="control-group">
                                <label class="control-label"><span>$ ${requestScope.price}</span></label>
                                <div class="controls">
                                    <input id="quantityToAdd" min="1" required="true"  type="number" class="span6" placeholder="1">
                                </div>
                            </div>

                            <h4>${requestScope.quantity} items in stock</h4>
                            <p>
                                ${requestScope.description}
                            <p>
                                <button id="addbtn" onclick="addProductToCart(${requestScope.id},${requestScope.price})" class="shopBtn"><span class=" icon-shopping-cart"></span> Add to cart</button>
                        </div>
                    </div>
                </div>
                <hr class="softn clr"/>
            </div>
        </div>
    </div> <!-- Body wrapper -->
</div><!-- /container -->
</body>
</html>