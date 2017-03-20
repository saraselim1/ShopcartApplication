
<jsp:directive.include  file="Header.jsp"/>
<div class="container">
    <div id="gototop"> </div>
    <div class="row">
        <div id="sidebar" class="span3">
        </div>
        <div class="span9">
            <h3> Registration</h3>	
            <hr class="soft"/>
            <div class="well">
                <form action = "UserAdd" method = "post" class="form-horizontal">
                    <h3>Your Personal Details</h3>

                    <div class="control-group">
                        <label class="control-label" for="inputFname">First name <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="fName" id="inputFname" placeholder="First Name">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputLname">Last name <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="lName" id="inputLname" placeholder="Last Name">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputLname">User name <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="userName" id="inputUsername" placeholder="User Name">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Email <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="email" placeholder="Email">
                        </div>
                    </div>	  
                    <div class="control-group">
                        <label class="control-label">Password <sup>*</sup></label>
                        <div class="controls">
                            <input type="password" name="password" placeholder="Password">
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
                                <option value="">-</option>
                                <option value="1">Male&nbsp;&nbsp;</option>
                                <option value="2">Female&nbsp;&nbsp;</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <input type="submit" name="submitAccount" value="Register" class="exclusive shopBtn">
                        </div>
                    </div>
                </form>
            </div>




        </div>
    </div>
</div><!-- /container -->
</body>
</html>