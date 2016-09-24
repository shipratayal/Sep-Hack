<%@ page import="com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<div class="row">
    <div class="col-md-12">
        <form action="${createLink(controller: 'label', action: 'saveLabel')}" method="post"
              enctype="multipart/form-data" class="form-horizontal ">
            <div class="row">
                <div class="col-sm-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="labelName" name="labelName" class="form-control"
                                           placeholder="Label name" required autofocus>
                                    <span class="help-block">Please enter your label name</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="color" name="color" class="form-control"
                                           placeholder="Color name" required>
                                    <span class="help-block">Please enter your color name</span>
                                </div>
                            </div>
                            <input type="hidden" name="repositoryId" value="${repositoryId}">

                        </div>

                        <div class="panel-footer">
                            <button type="submit" class="btn btn-sm btn-primary"><i
                                    class="fa fa-dot-circle-o"></i> Submit</button>
                            <button type="reset" class="btn btn-sm btn-danger"><i class="fa fa-ban"></i> Reset
                            </button>
                        </div>
                    </div>
                </div><!--/col-->

            </div>
        </form>
    </div>
</div>
</body>
</html>