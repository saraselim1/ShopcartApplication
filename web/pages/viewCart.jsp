
<jsp:directive.include  file="Header.jsp"/>
<script>
    function updateItem(item){
        console.log(item);
        $.ajax({
            url:"UpdateProductCartServlet",
            type: 'POST',
            contentType: 'application/json',
            data: {price:item.price,quantity:item.quantity,cartId:cartID,productId:productId},
            dataType: 'json'
        });
    }
    function deleteItem(cartId,productId){
        console.log(item);
        $.ajax({
            url:"DeleteProductFromCartServlet",
            type: 'GET',
            contentType: 'application/json',
            data: {cartId:cartID,productId:productId},
            dataType: 'json'
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
                            <tr >
                                <td><img width="100" src="assets/img/e.jpg" alt=""></td>
                                <td>Items name here<br>Carate : 22<br>Model : n/a</td>
                                <td>${item.price}</td>
                                <td>
                                    <input class="span1" style="max-width:40px" placeholder="1" 
                                           id="appendedInputButtons" size="16" type="number" value="${item.quantity}">
                                    <div class="input-append">
                                        <button onclick="updateItem(${item})" class="btn btn-mini btn-success" type="button"><span class="icon-ok"></span></button>
                                        <button onclick="deleteItem(${sessionScope.user.cart.id},${item.productId})" class="btn btn-mini btn-danger" type="button"><span class="icon-remove"></span></button>
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
                <a href="Home" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
                <a href="BuyingServlet" class="shopBtn btn-large pull-right">Next <span class="icon-arrow-right"></span></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
