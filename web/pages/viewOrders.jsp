
<jsp:directive.include  file="Header.jsp"/>
<div class="container">
    <div class="row">
        <div class="span12">
            <c:if test="${sessionScope.user.orders} > 0" >
                <c:forEach items="${sessionScope.user.orders}" var="order">
                    <div class="well well-small">
                        <h1><small class="pull-right">${fn:length(order.product)} Items with cost ${order.totalPrice} at ${order.date}  </small></h1>
                        <hr class="soften"/>	
                        <table class="table table-bordered table-condensed">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Unit price</th>
                                    <th>Quantity </th>
                                    <th>Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${order.product}" var="item">
                                    <c:set var="itemDetalias" 
                                           value="${applicationScope.productList.stream().filter( ppp -> ppp.getId()==item.getProductId()).toList().get(0) }"/>
                                    <tr >
                                        <td>${itemDetalias.name}<br>${itemDetalias.description}</td>
                                        <td>${item.price}</td>
                                        <td>${item.quantity}</td>
                                        <td>${item.price * item.quantity}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table><br/>		
                        <a href="/Home" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${sessionScope.user.orders.size() == 0}" >
                <div class="well well-small">
                    <h1>No Order</h1>
                    <hr class="soften"/>	
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
