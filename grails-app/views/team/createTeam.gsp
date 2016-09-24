<%--
  Created by IntelliJ IDEA.
  User: deshraj
  Date: 24/9/16
  Time: 8:40 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user">
    <title></title>
</head>

<body>







<form action="${createLink(controller: 'issue', action: 'submitIssue')}" method="post"
      enctype="multipart/form-data" class="form-horizontal ">
    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" id="teamname" name="teamname" class="form-control"
                                   placeholder="Team Name" required autofocus>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <g:select id="author" name='authors'
                                  noSelection="${[[]: 'Select Members']}"
                                  from='${com.User.list()}'
                                  optionKey="id" optionValue="firstName"
                                  class="form-control input-sm"
                                  size="1"/>
                        <hr/>
                    </div>



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







</body>
</html>