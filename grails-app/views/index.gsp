<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="theme"/>
    <title>Login To Your Account</title>
</head>

<body>

<div class="container-fluid content">
    <div class="row">
        <div id="content" class="col-sm-12 full">
            <div class="row">
                <div class="login-box">

                    <div class="header">
                        Login to Clever Admin
                    </div>

                    <form class="form-horizontal login" action="${request.contextPath}/j_spring_security_check"
                          method="post">

                        <fieldset class="col-sm-12">
                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="text" class="form-control" id="j_username" name="j_username"
                                               placeholder="Username or E-mail" required autofocus
                                               name="j_username"/>
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="password" class="form-control" id="j_password"
                                               name="j_password"
                                               placeholder="Password"/>
                                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                                    </div>
                                </div>
                            </div>

                            <div class="confirm">
                                <input type="checkbox" value="remember-me" name="${rememberMeParameter}"
                                       id="remember_me"/>
                                <label for="remember_me">Remember me</label>
                            </div>

                            <div class="row">

                                <button type="submit" class="btn btn-lg btn-primary col-xs-12">Login</button>

                            </div>

                        </fieldset>

                    </form>

                    %{--<a class="pull-left" href="page-login.html#">Forgot Password?</a>--}%
                    <g:link action="signUp" controller="public" class="pull-right">SIGN UP</g:link>


                    <div class="clearfix"></div>

                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>
