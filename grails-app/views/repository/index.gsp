<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="user"/>
    <g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="col-md-10 col-sm-11 main ">
    <div class="nav" role="navigation">
        <div class="row">
            <div class="col-md-1">
                <a class="home btn btn-primary" href="${createLink(uri: '/')}"><g:message
                        code="default.home.label"/></a>
            </div>

            <div class="col-md-1">
                <g:link class="create btn btn-primary" action="create"><g:message code="default.new.label"
                                                                                  args="[entityName]"/></g:link>
            </div>
        </div>
    </div>
    <br/>

    <div class="panel panel-default">

        <div class="panel-body">

            <div id="list-repository" class="content scaffold-list" role="main">
                <g:render template="repositoryFilter"
                          model="[repositoryInstanceList: repositoryInstanceList, repositoryInstanceCount: repositoryInstanceCount]"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
