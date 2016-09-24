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
        <g:form controller="label">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td>
                    <input type="text" name="labelName" value="${fieldValue(bean: labelInstance, field: "title")}">
            </td>

            <td>
                <input type="text" name="labelColor" value="${fieldValue(bean: labelInstance, field: "color")}">
                <input type="hidden" name="labelId" value="${labelInstance.id}">
                <input type="hidden" name="repositoryId" value="${repositoryId}">
            </td>

            <td>
                <g:actionSubmit value="Delete" action="deleteLabel"></g:actionSubmit>
                <g:actionSubmit value="Update" action="updateLabel"></g:actionSubmit>
            </td>

        </tr>
        </g:form>
    </g:each>
    </tbody>
</table>

<util:remotePaginate controller="repository" action="filter" total="${Label.count()}"
                     update="showLabel" max="20"
                     pageSizes="[10: '10 Per Page', 20: '20 Per Page', 50: '50 Per Page', 100: '100 Per Page']"/>