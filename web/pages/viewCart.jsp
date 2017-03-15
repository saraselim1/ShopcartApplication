
<jsp:directive.include  file="Header.jsp"/>

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
                        <tr>
                            <td><img width="100" src="assets/img/e.jpg" alt=""></td>
                            <td>Items name here<br>Carate : 22<br>Model : n/a</td>
                            <td>${item.price}</td>
                            <td><input class="span1" style="max-width:34px" placeholder="1" 
                                       id="appendedInputButtons" size="16" type="number" value="${item.quantity}">
                                <div class="input-append">
                                    <button class="btn btn-mini" type="button"> - </button>
                                    <button class="btn btn-mini" type="button"> + </button>
                                    <button class="btn btn-mini btn-danger" type="button"><span class="icon-remove"></span></button>
                                    <button class="btn btn-mini btn-danger" type="button"><span class="icon-remove"></span></button>
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

                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="shopBtn">Buy</button>
                    </div>
                </div>		
                <a href="/Home" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
                <a href="login.html" class="shopBtn btn-large pull-right">Next <span class="icon-arrow-right"></span></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
