<jsp:directive.include  file="Header.jsp"/>
<div class="container">
    <div class="row">
        <div class="span12">
            <c:if test="${requestScope.msg != null }">
                <label>${requestScope.msg}</label>
            </c:if>
            <c:if test="${requestScope.msg == null }">
                <div class="well well-small">
                    <h1>Successful buying <small class="pull-right">
                            <h3>Total price : ${requestScope.order.totalPrice} </h3> </small></h1>
                    <hr class="soften"/>	
                    <a href="${pageContext.request.contextPath}/pages/home.jsp" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
                </div></c:if>
        </div>
    </div>
</div>
</body>
</html>
