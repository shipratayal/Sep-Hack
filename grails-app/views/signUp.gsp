<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="theme"/>

    <title>Sign Up</title>
</head>

<body>
<div class="container-fluid content">
    <div class="row">
        <div id="content" class="col-sm-12 full">
            <div class="row">
                <div class="login-box">

                    <div class="header">
                        Create a Free Account
                    </div>

                    <g:form class="form-horizontal login" controller="user" action="create"
                            method="post">

                        <fieldset class="col-sm-12">
                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="text" class="form-control" id="firstName" name="firstName"
                                               placeholder="First Name"/>
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="text" class="form-control" id="lastName" name="lastName"
                                               placeholder="Last Name"/>
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="text" class="form-control" id="username" name="username"
                                               placeholder="Username or E-mail"/>
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="password" class="form-control" id="password" name="password"
                                               placeholder="Password"/>
                                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="password" class="form-control" id="confirmPassword"
                                               name="confirmPassword"
                                               placeholder="Confirm Password"/>
                                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                                    </div>
                                </div>
                            </div>


                            <div class="row">

                                <button type="submit" class="btn btn-lg btn-primary col-xs-12">SIGN UP</button>

                            </div>

                        </fieldset>

                    </g:form>

                %{--<a class="pull-left" href="page-login.html#">Forgot Password?</a>--}%
                %{--<a class="pull-right" href="page-register.html">Sign Up!</a>--}%

                    <div class="clearfix"></div>

                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>