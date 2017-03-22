<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Users</title>
        <link href="../assetsadmin/css/bootstrap.css" rel="stylesheet" />
        <link href="../assetsadmin/css/font-awesome.css" rel="stylesheet" />
        <link href="../assetsadmin/css/custom.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <link href="../assetsadmin/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    </head>
    <body>


        <jsp:include page="AdminHeader.jsp" ></jsp:include>


        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Orders</h2>   
                        <h5>Orders view </h5>
                    </div>
                </div>
                
                <hr />

                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                System Orders
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Order Id</th>
                                                <th>Total Price</th>
                                                <th>Date</th>
                                                <th>User ID</th>
                                                <th>product</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="order" items="${ordersAll}">
                                                <tr class="odd gradeX">
                                                    <td><a href="#"><c:out value="${order.id}"/></a></td>
                                                    <td><c:out value="${order.totalPrice}"/></td>
                                                    <td><c:out value="${order.date}"/></td>
                                                    <td><c:out value="${order.userId}"/></td>
                                                    <td><c:out value="${order.product}"/></td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <script>
            function ConfirmDelete()
            {
                var x = confirm("Are you sure you want to delete User?");
                if (x)
                    document.location.href="../AdminDeleteUser?deleteuser=${user.userName}"; 
                else
                    return false;
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


    </body>
</html>
