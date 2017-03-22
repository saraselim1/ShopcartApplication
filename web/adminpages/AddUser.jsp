<%-- 
    Document   : signUp
    Created on : Mar 13, 2017, 3:41:16 PM
    Author     : Sara Selim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        
        <link href="../assetsadmin/css/bootstrap.css" rel="stylesheet" />
        <link href="../assetsadmin/css/font-awesome.css" rel="stylesheet" />
        <link href="../assetsadmin/css/custom.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <link href="../assetsadmin/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
        
    </head>
    <body>
        
        
        
         <jsp:include page="AdminHeader.jsp" ></jsp:include>
        
        



        <div class="container">
            <div id="gototop"> </div>
            <header id="header">
                
            </header>

         
            <div class="row">
                <div id="sidebar" class="span3">
                    <br><br>
                </div>
                
                <div class="span9">
                    <ul class="breadcrumb">
                    </ul>
                    <h3> Add User</h3>	
                    
                    <hr class="soft"/>
                    <div class="well">
                        <form action = "../AdminAddUser" method = "post" class="form-horizontal">
                            <h3>User Data</h3>

                            <div class="control-group">
                                <label class="control-label" for="inputFname">First name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="fName" id="inputFname" placeholder="First Name" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputLname">Last name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="lName" id="inputLname" placeholder="Last Name" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputLname">User name <sup>*</sup></label>
                                <div class="controls">
                                    <input type="text" name="userName" id="inputUsername" placeholder="User Name" required>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="inputEmail">Email <sup>*</sup></label>
                                <div class="controls">
                                    <input type="email" name="email" placeholder="Email" required>
                                </div>
                            </div>	  
                            <div class="control-group">
                                <label class="control-label">Password <sup>*</sup></label>
                                <div class="controls">
                                    <input type="password" name="password" placeholder="Password" required="">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Address <sup>*</sup></label>
                                <div class="controls">
                                    <textarea name="address"></textarea>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Gender <sup>*</sup></label>
                                <div class="controls">
                                    <select class="span1" name="gender">
                                        <option value="Male">Male&nbsp;&nbsp;</option>
                                        <option value="Male">Female&nbsp;&nbsp;</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <input type="submit" name="submitAccount" class="btn btn-primary btn-lg" value="Add" class="exclusive shopBtn">
                                </div>
                            </div>
                        </form>
                    </div>




                </div>
            </div>            
        </div><!-- /container -->
        
        

        
        

        
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.easing-1.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/shop.js"></script>
        
        
        
                        <script type="text/javascript">
            $(document).ready(function () {
                var panels = $('.user-infos');
                var panelsButton = $('.dropdown-user');
                panels.hide();

                //Click dropdown
                panelsButton.click(function () {
                    //get data-for attribute
                    var dataFor = $(this).attr('data-for');
                    var idFor = $(dataFor);

                    //current button
                    var currentButton = $(this);
                    idFor.slideToggle(400, function () {
                        //Completed slidetoggle
                        if (idFor.is(':visible'))
                        {
                            currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
                        } else
                        {
                            currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
                        }
                    });
                });


                $('[data-toggle="tooltip"]').tooltip();

                $('button').click(function (e) {
                    e.preventDefault();
                    alert("This is a demo.\n :-)");
                });
            });
        </script>
        
        
        

        <script src="${pageContext.request.contextPath}/assetsadmin/js/jquery-1.10.2.js"></script>
        <script src="${pageContext.request.contextPath}/assetsadmin/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assetsadmin/js/jquery.metisMenu.js"></script>
        <script src="${pageContext.request.contextPath}/assetsadmin/js/dataTables/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/assetsadmin/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
        </script>
        <script src="${pageContext.request.contextPath}/assetsadmin/js/custom.js"></script>
        
        
        
    </body>
</html>