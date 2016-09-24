<%@ page import="com.nexthoughts.stuff.Issue; com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>

<body>
<div class="row">
    <div class="col-md-12">
        <form action="${createLink(controller: 'milestone', action: 'saveMilestone')}" method="post"
              enctype="multipart/form-data" class="form-horizontal ">
            <div class="row">
                <div class="col-sm-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="milestoneName" name="milestoneName" class="form-control"
                                           placeholder="Milestone Name" required autofocus>
                                    <span class="help-block">Please enter your Milestone name</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="description" name="description" class="form-control"
                                           placeholder="Description" required>
                                    <span class="help-block">Please enter Description</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <input type="text" id="datepicker" name="dueDate" class="form-control"
                                           placeholder="Due Date" required>
                                    <span class="help-block">Due Date</span>
                                </div>
                            </div>
                            <g:select name="issue" from="${com.nexthoughts.stuff.Issue.list()}" multiple="multiple"
                                      optionKey="id"
                                      optionValue="title" size="5" value="${repositoryInstance?.issue*.id}"
                                      class="many-to-many form-control"/>

                            <input type="hidden" name="repositoryId" value="${repositoryId}">
                            <span class="help-block">Select Issue</span>

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
<script>

</script>
</body>
</html>