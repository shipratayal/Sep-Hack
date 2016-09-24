<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="user"/>
</head>

<body>
<div class="row">
    <div class="col-sm-12">

        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="javascript:void(0)" class="btn btn-default">Label</a>
                %{--<a href="${createLink(controller: 'label', action: 'index')}" class="btn btn-default">Milestone</a>--}%

                <div class="pull-right">
                    <a href="${createLink(controller: 'label', action: 'createLabel', params: [repositoryId: repositoryId])}"
                       class="btn btn-success">New Label</a>
                </div>
            </div>

            <div class="panel-body">
                <div id="showLabel">
                    <g:render template="labelFilter"
                              model="[labelInstanceList: labelInstanceList, labelInstanceTotal: labelInstanceTotal]"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>