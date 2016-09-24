<%@ page import="com.nexthoughts.stuff.Label; com.User" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome !!</title>
</head>

<body>
<div class="row">
    <div class="col-sm-12">

        <div class="panel panel-default">
            <div class="panel-heading">Panel heading without title</div>

            <div class="panel-body">
                <div class="pull-right">
                    <a href="${createLink(controller: 'issue', action: 'createIssue', params: [repositoryId: repositoryId])}"
                       class="btn btn-success">New Issue</a>
                </div>
            </div>
        </div>

    </div><!--/col-->
</div>

<div class="row">
    <div class="col-sm-12">

        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="form-group">
                    <div class="col-md-2">
                        <g:checkBox name="selectAll" class="flat-red"
                                    onclick="selectAll(this)"/>
                    </div>

                    <div class="col-md-10 pull-right">
                        <div class="row">
                            <div class="col-md-3">
                                <g:select id="author" name='authors'
                                          noSelection="${['null': 'Select Authors']}"
                                          from='${User.list()}'
                                          optionKey="id" optionValue="firstName"
                                          class="form-control input-sm"
                                          size="1"/>
                            </div>

                            <div class="col-md-3">
                                <g:select id="label" name='labels'
                                          noSelection="${['null': 'Select Label']}"
                                          from='${Label.list()}'
                                          optionKey="id" optionValue="title" class="form-control input-sm"
                                          size="1"/>
                            </div>

                            <div class="col-md-3">
                                <g:select id="milestone" name='milestone'
                                          noSelection="${['null': 'Select Milestone']}"
                                          from='${Label.list()}'
                                          optionKey="id" optionValue="title" class="form-control input-sm"
                                          size="1"/>
                            </div>

                            <div class="col-md-3">
                                <g:select id="author" name='authors'
                                          noSelection="${['null': 'Select Assignee']}"
                                          from='${User.list()}'
                                          optionKey="id" optionValue="firstName"
                                          class="form-control input-sm"
                                          size="1"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="panel-body">
                <g:each in="${issues}" var="issue" status="index">
                    Issue no. ${index+1} = ${issue.title} <br/>
                </g:each>
            </div>
        </div>

    </div>
</div>
<script>
    function selectAll(checkbox) {
        var boolean = checkbox.checked;
        if (boolean) {
            $('.loanToBeApproved').prop("checked", true);
        } else {
            $('.loanToBeApproved').prop("checked", false);
        }
    }
</script>
</body>
</html>