<jsp:directive.include  file="Header.jsp"/>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="well well-small">
                <h1>Successful buying <small class="pull-right">
                       <h3>Total price : </h3> ${requestScope.order.totalPrice}  </small></h1>
                <hr class="soften"/>	
                <a href="${pageContext.request.contextPath}/pages/home.jsp" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
