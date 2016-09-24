<%@ page import="com.nexthoughts.stuff.Issue; com.nexthoughts.issuetracker.Repository" %>
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
    </tr>
    </thead>
    <tbody>
    <g:each in="${issues}" status="i" var="issue">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

            <td>
                <g:link action="index" id="${issue.id}">
                    ${fieldValue(bean: issue, field: "title")}
                </g:link>
            </td>

            <td>${raw(fieldValue(bean: issue, field: "description"))}</td>

        </tr>
    </g:each>
    </tbody>
</table>

<util:remotePaginate controller="repository" action="filter"
                     total="${issues?.size()}"
                     update="list-repository" max="20"
                     pageSizes="[10: '10 Per Page', 20: '20 Per Page', 50: '50 Per Page', 100: '100 Per Page']"/>