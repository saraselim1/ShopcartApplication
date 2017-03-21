<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title> Admin </title>
        <link href="../assetsadmin/css/bootstrap.css" rel="stylesheet" />
        <link href="../assetsadmin/css/font-awesome.css" rel="stylesheet" />
        <link href="../assetsadmin/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <link href="../assetsadmin/css/custom.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <script src="../assetsadmin/js/jquery-1.10.2.js"></script>
        <script src="../assetsadmin/js/bootstrap.min.js"></script>
        <script src="../assetsadmin/js/jquery.metisMenu.js"></script>
        <script src="../assetsadmin/js/morris/raphael-2.1.0.min.js"></script>
        <script src="../assetsadmin/js/morris/morris.js"></script>
        <script src="../assetsadmin/js/custom.js"></script>
    </head>
    <body>
        <script>
             function UpdateProduct()
            {
                
                $("#submitBtn").click();
            }

        </script>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-3">
                <form action ="${pageContext.request.contextPath}/UpdateProductServlet" method = "POST" >
                <div class="form-group">
                    <input hidden="true" name='id' type="text" value="${requestScope.product.id}" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input name='name' type="text" value="${requestScope.product.name}" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Quantity In Stock</label>
                    <input name='quantity' value="${requestScope.product.quantity}"  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input name='price' value="${requestScope.product.price}"  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Offer</label>
                    <input name='offer' value="${requestScope.product.offer}"  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input name='description' value="${requestScope.product.description}" type="text" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Category ID</label>
                    <input name='categoryId' value="${requestScope.product.categoryId}"  min="1" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Img</label>
                    <input name='imgMaster' value="${requestScope.product.imgMaster}" type="text" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <button type="submit" class="btn btn-default">Update Button</button>
                <button type="reset" class="btn btn-primary">Reset Button</button>

            </form>
            </div>
            </div>
        </div>
        
        <form hidden method="Post" action="${pageContext.request.contextPath}/UpdateProductServlet">
                <input hidden type="text" name="name" value="${product.name}">
                <input hidden type="text" name="id" value="${product.id}">
                <input hidden type="text" name="quantity" value="${product.quantity}">
                <input hidden type="text" name="price" value="${product.price}">
                <input hidden type="text" name="offer" value="${product.offer}">
                <input hidden type="text" name="description" value="${product.description}">
                <input hidden type="text" name="categoryId" value="${product.categoryId}">
                <input hidden type="text" name="imgMaster" value="${product.imgMaster}">
                <input hidden id="submitBtn" type='submit' />
            </form>
                
    </body>
</html>
                        
