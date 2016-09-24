<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="user"/>
    <g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="container-fluid content">
    <div class="row">

        <g:render template="/user/navigation"/>

        <div class="col-md-10 col-sm-11 main ">
            <div class="nav" role="navigation">
                <div class="row">
                    <div class="col-md-1">
                        <li><a class="home btn btn-primary" href="${createLink(uri: '/')}"><g:message
                                code="default.home.label"/></a>
                        </li>
                    </div>

                    <div class="col-md-1">
                        <li><g:link class="create btn btn-primary" action="create"><g:message code="default.new.label"
                                                                                              args="[entityName]"/></g:link></li>
                    </div>
                </div>
            </div>

            <div id="list-repository" class="content scaffold-list" role="main">
                <h1><g:message code="default.list.label" args="[entityName]"/></h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <table>
                    <thead>
                    <tr>

                        <td style="width:40px;"><g:sortableColumn property="name"
                                                                  title="${message(code: 'repository.name.label', default: 'Name')}"/></td>

                        <td style="width: 40px;"><g:sortableColumn property="description"
                                                                   title="${message(code: 'repository.description.label', default: 'Description')}"/></td>

                        <td style="width: 40px;"><g:sortableColumn property="accessLevel"
                                                                   title="${message(code: 'repository.accessLevel.label', default: 'Access Level')}"/></td>

                        %{--<td style="width: 20px;"><g:sortableColumn property="dateCreated"--}%
                        %{--title="${message(code: 'repository.dateCreated.label', default: 'Date Created')}"/></td>--}%

                        <td style="width: 40px;"><g:sortableColumn property="isDeleted"
                                                                   title="${message(code: 'repository.isDeleted.label', default: 'Is Deleted')}"/></td>

                        %{--<td style="width:20px;"><g:sortableColumn property="lastUpdated"--}%
                        %{--title="${message(code: 'repository.lastUpdated.label', default: 'Last Updated')}"/></td>--}%

                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${repositoryInstanceList}" status="i" var="repositoryInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                            <td style="width: 40px"><g:link action="show"
                                                            id="${repositoryInstance.id}">${fieldValue(bean: repositoryInstance, field: "name")}</g:link></td>

                            <td style="width:40px;">${fieldValue(bean: repositoryInstance, field: "description")}</td>

                            <td style="width:40px;">${fieldValue(bean: repositoryInstance, field: "accessLevel")}</td>

                            %{--<td><g:formatDate date="${repositoryInstance.dateCreated}"/></td>--}%

                            <td style="width:40px;"><g:formatBoolean boolean="${repositoryInstance.isDeleted}"/></td>

                        %{--<td><g:formatDate date="${repositoryInstance.lastUpdated}"/></td>--}%
                        %{--<td style="width:40px"><g:link class="btn btn-primary" controller="repository"--}%
                        %{--action="edit"--}%
                        %{--id="${repositoryInstance.id}">EDIT</g:link></td>--}%
                            <g:form url="[resource: repositoryInstance, action: 'delete']" method="DELETE">
                                <fieldset class="buttons">
                                    <td><g:link class="edit" action="edit" resource="${repositoryInstance}"><g:message
                                            code="default.button.edit.label" default="Edit"/></g:link></td>
                                    <td><g:actionSubmit class="delete" action="delete"
                                                        value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></td>
                                </fieldset>
                            </g:form>
                        </tr>
                    </g:each>
                    </tbody>
                </table>

                <div class="pagination">
                    <g:paginate total="${repositoryInstanceCount ?: 0}"/>
                </div>
            </div>
        </div>

    </div>

</div>

</body>
</html>
