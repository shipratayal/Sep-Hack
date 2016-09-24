<%@ page import="com.nexthoughts.stuff.Label; com.nexthoughts.issuetracker.Repository" %>
<table class="table table-bordered">
    <thead>
    <tr>
        <util:remoteSortableColumn property="title" title="${message(code: 'ndame.label', default: 'Title')}"
                                   update="showLabel" action="filter"/>
        <util:remoteSortableColumn property="description"
                                   title="${message(code: 'descriptiodn.label', default: 'Color')}"
                                   update="showLabel" action="filter"/>
    </tr>
    </thead>
    <tbody>
    <g:each in="${labelInstanceList}" status="i" var="labelInstance">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td>
                <g:link action="edit" id="${labelInstance.title}">
                    ${fieldValue(bean: labelInstance, field: "title")}
                </g:link>
            </td>

            <td>${fieldValue(bean: labelInstance, field: "description")}</td>

        </tr>
    </g:each>
    </tbody>
</table>

<util:remotePaginate controller="repository" action="filter" total="${Label.count()}"
                     update="showLabel" max="20"
                     pageSizes="[10: '10 Per Page', 20: '20 Per Page', 50: '50 Per Page', 100: '100 Per Page']"/>