<%-- 
    Document   : profile
    Created on : Mar 13, 2017, 3:41:03 PM
    Author     : Sara Selim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
        <title>Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            .user-row {
                margin-bottom: 14px;
            }

            .user-row:last-child {
                margin-bottom: 0;
            }

            .dropdown-user {
                margin: 13px 0;
                padding: 5px;
                height: 100%;
            }

            .dropdown-user:hover {
                cursor: pointer;
            }

            .table-user-information > tbody > tr {
                border-top: 1px solid rgb(221, 221, 221);
            }

            .table-user-information > tbody > tr:first-child {
                border-top: 0;
            }


            .table-user-information > tbody > tr > td {
                border-top: 0;
            }
            .toppad
            {margin-top:20px;
            }

        </style>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        
         <jsp:include page="Header.jsp" ></jsp:include>
        <div class="container">
            <div class="row">
                <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
                    <A href="EditProfileServlet" >Edit Profile</A>

                    <A href="edit.html" >Logout</A>
                    <br>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">${user.userName}</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="imgs/user.png" class="img-circle img-responsive"> </div>


                                <div class=" col-md-9 col-lg-9 "> 
                                    <table class="table table-user-information">
                                        <tbody>
                                            <tr>
                                                <td>First Name</td>
                                                <td>${user.fname}</td>
                                            </tr>
                                            <tr>
                                                <td>Last Name</td>
                                                <td>${user.lname}</td>
                                            </tr>
                                            <tr>
                                                <td>Email</td>
                                                <td><a href="#">${user.email}</a></td>
                                            </tr>
                                            <tr>
                                                <td>Address</td>
                                                <td>${user.address}</td>
                                            </tr>

                                            <tr>
                                                <td>Gender</td>
                                                <td>${user.gender}</td>
                                            </tr>
                                            <tr>
                                                <td>PassWord</td>
                                                <td>***********</td>
                                            </tr>

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <span class="pull-right">
                                <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                            </span>
                        </div>

                    </div>
                </div>
            </div>
        </div>
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
    </body>
</html>

