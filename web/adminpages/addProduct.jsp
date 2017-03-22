<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
﻿<!DOCTYPE html>
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

            <center>
                <br><br><br>
                            <div class="panel-body" >
                                <div class="row">
                                    <div class="col-md-3">
                                        <form action="${pageContext.request.contextPath}/AddProductSevlet" method="post" ENCTYPE="MULTIPART/FORM-DATA" >
                                        <script>console.log("${pageContext.request.contextPath}/AddProductSevlet");</script>
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input name='name' type="text" value="" class="form-control" placeholder="PLease Enter Keyword" />
                                        </div>
                                        <div class="form-group">
                                            <label>Quantity In Stock</label>
                                            <input name="quantity" value=""  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                                        </div>
                                        <div class="form-group">
                                            <label>Price</label>
                                            <input name='price' value=""  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                                        </div>
                                        <div class="form-group">
                                            <label>Offer</label>
                                            <input name='offer' value=""  min="0" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                                        </div>
                                        <div class="form-group">
                                            <label>Description</label>
                                            <input name='description' value="" type="text" class="form-control" placeholder="PLease Enter Keyword" />
                                        </div>
                                        <div class="form-group">
                                            <label>Category ID</label>
                                            <input name='categoryId' value=""  min="1" type="number" class="form-control" placeholder="PLease Enter Keyword" />
                                        </div>
                                        <!--                <div class="form-group">
                                                            <label>Img</label>
                                                            <input name='imgMaster' value="" type="text" class="form-control" placeholder="PLease Enter Keyword" />
                                                        </div>-->
                                        <div class="form-group">
                                            <label>Img</label>
                                            <input name='productimg' value="" type="file" class="form-control" placeholder="Product Img" />
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-primary">Reset Button</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                        </center>

                        </div>

                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>
            </div>

        </div>


    </body>
</html>


