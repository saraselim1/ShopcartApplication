<%-- 
    Document   : AdminHeader
    Created on : Mar 20, 2017, 4:49:16 PM
    Author     : M_Mustafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Users</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="${pageContext.request.contextPath}/assetsadmin/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="${pageContext.request.contextPath}/assetsadmin/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->

        <!-- CUSTOM STYLES-->
        <link href="${pageContext.request.contextPath}/assetsadmin/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- TABLE STYLES-->
        <link href="${pageContext.request.contextPath}/assetsadmin/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    </head>
    <body>
       
        
          <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="AdminHome.jsp">Project Admin</a> 
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;">  <a href="${pageContext.request.contextPath}/LogOutServlet" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="${pageContext.request.contextPath}/assetsadmin/img/find_user.png" class="user-image img-responsive"/>
                        </li>
                        <li>
                            <a  href="${pageContext.request.contextPath}/adminpages/AdminHome.jsp"><i class="fa fa-dashboard fa-3x"></i> Home</a>
                        </li>
                        <li>
                            <a  href="${pageContext.request.contextPath}/ViewAllUsers"><i class="fa fa-table fa-3x"></i> Users</a>
                        </li>
                        <li>
                            <a  href="${pageContext.request.contextPath}/AdminViewProducts"><i class="fa fa-table fa-3x"></i> Products</a>
                        </li>
                        <li>
                            <a  href="${pageContext.request.contextPath}/AdminViewCategory"><i class="fa fa-table fa-3x"></i> Category</a>
                        </li>
                        <li>
                            <a  href="${pageContext.request.contextPath}/adminpages/#"><i class="fa fa-table fa-3x"></i> Orders</a>
                        </li>
                        <li>
                            <a  href="${pageContext.request.contextPath}/AdminViewServlet"><i class="fa fa-table fa-3x"></i> Admins</a>
                        </li>
                       
                    </ul>
                </div>

            </nav>  
        </div>
        
        
    </body>
</html>
