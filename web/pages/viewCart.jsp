
<jsp:directive.include  file="Header.jsp"/>
<script>
    function updateItem(productIDValue, priceValue) {
        var newQuantity = $('#' + productIDValue).val();
        $.post("UpdateProductCartServlet?date" + new Date(),
                {
                    quantity: newQuantity,
                    price: priceValue,
                    productId: productIDValue
                },
                function (data, status) {
                    alert(data);
                });
    }
    function deleteItem(productIdValue) {
        $.ajax({
            url: "DeleteProductFromCartServlet?date" + new Date(),
            type: 'GET',
            contentType: 'application/json',
            data: {productId: productIdValue},
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                   $('#tr' + productIdValue).remove();         
                        }
        });

    }
</script>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="well well-small">
                <h1>Check Out <small class="pull-right"> ${fn:length(sessionScope.user.cart.product)} Items are in the cart </small></h1>
                <hr class="soften"/>	
                <table class="table table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Description</th>
                            <th>Unit price</th>
                            <th>Quantity </th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="total" value="${0}"/>
                        <c:forEach items="${sessionScope.user.cart.product}" var="item">
                            <c:set var="itemDetalias" 
                                   value="${applicationScope.productList.stream().filter( ppp -> ppp.getId()==item.getProductId()).toList().get(0) }"/>
                            <tr id="tr${item.productId}" >
                                <td><img width="100" src="${ititemDetalias.imgMaster}" alt=""></td>
                                <td>${itemDetalias.name}<br>${itemDetalias.description}</td>
                                <td>${item.price}</td>
                                <td>
                                    <input class="span1" style="max-width:40px" placeholder="1" 
                                           id="${item.productId}" size="16" type="number" value="${item.quantity}">
                                    <div class="input-append">
                                        <button onclick="updateItem(${item.productId},${item.price})" class="btn btn-mini btn-success" type="button"><span class="icon-ok"></span></button>
                                        <button onclick="deleteItem(${item.productId})" class="btn btn-mini btn-danger" type="button"><span class="icon-remove"></span></button>
                                    </div>
                                </td>
                                <td>${item.price * item.quantity}</td>
                                <c:set var="total" value="${total + (item.price* item.quantity)}" />
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="6" class="alignR">Total products:	</td>
                            <td> ${total}</td>
                        </tr>
                    </tbody>
                </table><br/>	
                <a href="${pageContext.request.contextPath}/pages/home.jsp" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
                <a href="BuyingServlet" class="shopBtn btn-large pull-right">Buy <span class="icon-arrow-right"></span></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
