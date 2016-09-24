<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<div id="list-repository" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<table class="table table-bordered">
    <thead>
    <tr>
        <util:remoteSortableColumn property="name" title="${message(code: 'name.label', default: 'Name')}"
                                   update="list-repository" action="filter"/>
        <util:remoteSortableColumn property="description"
                                   title="${message(code: 'description.label', default: 'Description')}"
                                   update="list-repository" action="filter"/>
        <util:remoteSortableColumn property="accessLevel"
                                   title="${message(code: 'accessLevel.label', default: 'Access')}"
                                   update="list-repository" action="filter"/>
        <util:remoteSortableColumn property="isDeleted" title="${message(code: 'isDeleted.label', default: 'Deleted')}"
                                   update="list-repository" action="filter"/>
    </tr>
    </thead>
    <tbody>
    <g:each in="${repositoryInstanceList}" status="i" var="repositoryInstance">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

            <td>
                <g:link action="edit" id="${repositoryInstance.name}">
                    ${fieldValue(bean: repositoryInstance, field: "name")}
                </g:link>
            </td>

            <td>${fieldValue(bean: repositoryInstance, field: "description")}</td>

            <td>${fieldValue(bean: repositoryInstance, field: "accessLevel")}</td>

            <td><a class="btn btn-danger"
                   href="${createLink(controller: "repository", action: "delete", params: [repoId: repositoryInstance?.id])}">Delete</a>
            </td>

        </tr>
    </g:each>
    </tbody>
</table>

<util:remotePaginate controller="repository" action="filter" total="${Repository.count()}"
                     update="list-repository" max="20"
                     pageSizes="[10: '10 Per Page', 20: '20 Per Page', 50: '50 Per Page', 100: '100 Per Page']"/>
