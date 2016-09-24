<%@ page import="com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-body">
                ${issue?.title}
                <div class="pull-right">
                    <g:link action="edit" id="${issue.id}">
                        Edit
                    </g:link>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <form action="${createLink(controller: 'issue', action: 'updateTickets')}" method="post"
              enctype="multipart/form-data" class="form-horizontal ">
            <div class="row">
                <div class="col-sm-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="title" name="title" class="form-control"
                                           placeholder="Title" value="${issue?.title}" readonly>
                                    <span class="help-block">Please enter your Title</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <textarea id="textarea" name="editor1" rows="9" class="form-control"
                                              placeholder="Description.." readonly>${issue?.description}</textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <textarea id="textarea-input" name="editor2" rows="9" class="form-control"
                                              placeholder="Description.." readonly>${issue?.description}</textarea>
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
                                              noSelection="${[[]: 'Select Label']}"
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
                                              noSelection="${[[]: 'Select Assignee']}"
                                              from='${User.list()}'
                                              optionKey="id" optionValue="firstName"
                                              class="form-control input-sm"
                                              size="1"/>
                                    <hr/>
                                </div>
                                <input type="hidden" name="repositoryId" value="${issue?.id}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    CKEDITOR.replace('editor2');

</script>
</body>
</html>