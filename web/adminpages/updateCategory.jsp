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
             function UpdateCategory()
            {
                
                $("#submitBtn").click();
            }

        </script>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-3">
                <form action ="${pageContext.request.contextPath}/UpdateCategoryServlet" method = "POST" >
                <div class="form-group">
                    <input hidden="true" name='id' type="text" value="${requestScope.category.id}" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input name='name' type="text" value="${requestScope.category.name}" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input name='description' value="${requestScope.category.description}"  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                <div class="form-group">
                    <label>Products Number</label>
                    <input name='productNum' value="${requestScope.category.productNum}"  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                </div>
                
                <button type="submit" class="btn btn-default">Update Button</button>
                <button type="reset" class="btn btn-primary">Reset Button</button>

            </form>
            </div>
            </div>
        </div>
        
        <form hidden method="Post" action="${pageContext.request.contextPath}/UpdateCategoryServlet">
                <input hidden type="text" name="name" value="${category.name}">
                <input hidden type="text" name="id" value="${category.id}">
                <input hidden type="text" name="description" value="${category.description}">
                <input hidden type="text" name="productNum" value="${category.productNum}">
                <input hidden id="submitBtn" type='submit' />
            </form>
                
    </body>
</html>
                        
