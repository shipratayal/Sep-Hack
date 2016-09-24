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
                <a href="javascript:void(0)" class="btn btn-default">Milestone</a>
                %{--<a href="${createLink(controller: 'label', action: 'index')}" class="btn btn-default">Milestone</a>--}%

                <div class="pull-right">
                    <a href="${createLink(controller: 'milestone', action: 'createMilestone', params: [repositoryId: repositoryId])}"
                       class="btn btn-success">New Milestone</a>
                </div>
            </div>

            <div class="panel-body">
                <div id="showLabel">
                    <g:render template="/milestone/milestoneFilter"
                              model="[milestoneInstanceList: milestoneInstanceList, milestoneInstanceTotal: milestoneInstanceTotal]"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>