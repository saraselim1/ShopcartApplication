<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Admins</title>
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
                        <h2>Admins</h2>   
                        <h5>Admins view and Edit </h5>
                        <a href="addAdmin.jsp" style="margin-left: 22cm" class="btn btn-primary btn-lg">Add Admin</a>

                    </div>
                </div>
                <!-- /. ROW  -->
                <hr />

                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                System Admins
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="admin" items="${admins}">
                                                <tr class="odd gradeX">
                                                    <td><c:out value="${admin.id}"/></td>
                                                    <td><a href="../GettingOneAdmin?aname=${admin.name}" name="adminName"><c:out value="${admin.name}"/></a></td>
                                                    <td><c:out value="${admin.email}"/></td>
                                                    <td class="center" ><a onclick="ConfirmDelete" class="btn btn-danger" href="../DeleteAdminServlet?adminName=${admin.name}">Delete</a></td>
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
            function ConfirmDelete()
            {
                var x = confirm("Are you sure you want to delete Admin?");
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
