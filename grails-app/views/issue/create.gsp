<%@ page import="com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<div class="row">
    <div class="col-md-12">
        <form action="${createLink(controller: 'issue', action: 'submitIssue')}" method="post"
              enctype="multipart/form-data" class="form-horizontal ">
            <div class="row">
                <div class="col-sm-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="email" id="email-input" name="email-input" class="form-control"
                                           placeholder="Title" required autofocus>
                                    <span class="help-block">Please enter your Title</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <textarea id="textarea-input" name="textarea-input" rows="9" class="form-control"
                                              placeholder="Description.."></textarea>
                                </div>
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
                <div class="col-sm-4">
                    <div class="panel panel-info">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <g:select id="label" name='labels'
                                              noSelection="${['null': 'Select Label']}"
                                              from='${Label.list()}'
                                              optionKey="id" optionValue="title" class="form-control input-sm"
                                              size="1"/>
                                    <hr/>
                                </div>


                                <div class="col-md-12">
                                    <g:select id="milestone" name='milestone'
                                              noSelection="${['null': 'Select Milestone']}"
                                              from='${Label.list()}'
                                              optionKey="id" optionValue="title" class="form-control input-sm"
                                              size="1"/>
                                    <hr/>
                                </div>

                                <div class="col-md-12">
                                    <g:select id="author" name='authors'
                                              noSelection="${['null': 'Select Assignee']}"
                                              from='${User.list()}'
                                              optionKey="id" optionValue="firstName"
                                              class="form-control input-sm"
                                              size="1"/>
                                    <hr/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>