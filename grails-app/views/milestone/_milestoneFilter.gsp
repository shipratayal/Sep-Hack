<%@ page import="com.nexthoughts.stuff.MileStone" %>
<table class="table table-bordered">
    <thead>
    <tr>
        <util:remoteSortableColumn property="title" title="${message(code: 'ndame.label', default: 'Title')}"
                                   update="showLabel" action="filter"/>
        <util:remoteSortableColumn property="description"
                                   title="${message(code: 'descriptiodn.label', default: 'Description')}"
                                   update="showLabel" action="filter"/>
        <util:remoteSortableColumn property="description"
                                   title="${message(code: 'descriptiodn.label', default: 'Due Date')}"
                                   update="showLabel" action="filter"/>
    </tr>
    </thead>
    <tbody>
    <g:each in="${milestoneInstanceList}" status="i" var="milestoneInstance">
        <g:form controller="label">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                <td>
                    <input type="text" name="labelName" value="${fieldValue(bean: milestoneInstance, field: "title")}">
                </td>

                <td>
                    <input type="text" name="labelDescription"
                           value="${fieldValue(bean: milestoneInstance, field: "description")}">

                </td>
                <td>
                    <input type="text" name="labelDueDate" value="${milestoneInstance.dueDate}">
                </td>

                <td>
                    %{--<g:actionSubmit value="Delete" action="deleteLabel"></g:actionSubmit>--}%
                    %{--<g:actionSubmit value="Update" action="updateLabel"></g:actionSubmit>--}%
                </td>

            </tr>
        </g:form>
    </g:each>
    </tbody>
</table>

<util:remotePaginate controller="repository" action="filter" total="${MileStone.count()}"
                     update="showLabel" max="20"
                     pageSizes="[10: '10 Per Page', 20: '20 Per Page', 50: '50 Per Page', 100: '100 Per Page']"/>