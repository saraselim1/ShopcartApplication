<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Users</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="../assetsadmin/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="../assetsadmin/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->

        <!-- CUSTOM STYLES-->
        <link href="../assetsadmin/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- TABLE STYLES-->
        <link href="../assetsadmin/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    </head>
    <body>


        <jsp:include page="AdminHeader.jsp" ></jsp:include>


        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Products</h2>   
                        <h5>Products view and Edit </h5>
                        <a href="addProduct.jsp" style="margin-left: 22cm" class="btn btn-primary btn-lg">Add Product</a>
                    </div>
                </div>
                <!-- /. ROW  -->
                <hr />

                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                System Products
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Product Name</th>
                                                <th>ID</th>
                                                <th>Quantity In Stock</th>
                                                <th>Price</th>
                                                <th>Offer</th>
                                                <th>Description</th>
                                                <th>Category ID</th>
                                                <th>Master Image Path</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="product" items="${productList}">
                                                <tr class="odd gradeX">
                                                    <td><a href="../AdminGetProductByName?name=${product.name}"><c:out value="${product.name}"/></a></td>
                                                    <td><c:out value="${product.id}"/></td>
                                                    <td><c:out value="${product.quantity}"/></td>
                                                    <td><c:out value="${product.price}"/></td>
                                                    <td><c:out value="${product.offer}"/></td>
                                                    <td><c:out value="${product.description}"/></td>
                                                    <td><c:out value="${product.categoryId}"/></td>
                                                    <td><c:out value="${product.imgMaster}"/></td>
                                                    <td class="center" ><a name="${product.name}" onclick="ConfirmDelete(name);" class="btn btn-danger">Delete</a></td>
                                                    <td class="center" ><a href="../renderUpdateProductServlet?name=${product.name}" class="btn btn-danger">Update</a></td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>
            </div>

        </div>


        <script>
            function ConfirmDelete(pName)
            {
                $("#t1").val(pName);
                $("#deleteBtn").click();
            }
           
        </script>

        <script src="../assetsadmin/js/jquery-1.10.2.js"></script>
        <script src="../assetsadmin/js/bootstrap.min.js"></script>
        <script src="../assetsadmin/js/jquery.metisMenu.js"></script>
        <script src="../assetsadmin/js/dataTables/jquery.dataTables.js"></script>
        <script src="../assetsadmin/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
        </script>
        <script src="../assetsadmin/js/custom.js"></script>
            
            <!-- -->
            <form hidden method="Post" action="${pageContext.request.contextPath}/DeleteProductServlet">
                <input id="t1" hidden type="text" name="productName" value="">
                <input hidden id="deleteBtn" type='submit' />
            </form>


    </body>
</html>

