<%@ page import="com.nexthoughts.issuetracker.Repository" %>



<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="repository.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" class="form-control" required="" value="${repositoryInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="repository.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="description" cols="40" rows="5" maxlength="500" required=""
                value="${repositoryInstance?.description}" class="form-control"/>

</div>

<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'accessLevel', 'error')} required">
    <label for="accessLevel">
        <g:message code="repository.accessLevel.label" default="Access Level"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select name="accessLevel" class="form-control" from="${com.nexthoughts.issuetracker.enums.AccessLevel?.values()}"
              keys="${com.nexthoughts.issuetracker.enums.AccessLevel.values()*.name()}" required=""
              value="${repositoryInstance?.accessLevel?.name()}"/>

</div>
<br>
<br>

%{--<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'isDeleted', 'error')} ">--}%
%{--<label for="isDeleted">--}%
%{--<g:message code="repository.isDeleted.label" default="Is Deleted"/>--}%

%{--</label>--}%
%{--<g:checkBox name="isDeleted" value="${repositoryInstance?.isDeleted}"/>--}%

%{--</div>--}%

%{--<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'objectStatus', 'error')} required">--}%
%{--<label for="objectStatus">--}%
%{--<g:message code="repository.objectStatus.label" default="Object Status"/>--}%
%{--<span class="required-indicator">*</span>--}%
%{--</label>--}%
%{--<g:select name="objectStatus" from="${com.nexthoughts.issuetracker.enums.ObjectStatus?.values()}"--}%
%{--keys="${com.nexthoughts.issuetracker.enums.ObjectStatus.values()*.name()}" required=""--}%
%{--value="${repositoryInstance?.objectStatus?.name()}"/>--}%

%{--</div>--}%

%{--
<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'owner', 'error')} required">
    <label for="owner">
        <g:message code="repository.owner.label" default="Owner"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="owner" name="owner.id" from="${com.User.list()}" optionKey="id" required=""
              optionValue="username" value="${repositoryInstance?.owner?.id}" class="many-to-one form-control"/>

</div>
--}%

%{--<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'teams', 'error')} ">
    <label for="teams">
        <g:message code="repository.teams.label" default="Teams"/>

    </label>
    <g:select name="teams" from="${com.nexthoughts.issuetracker.Team.list()}" multiple="multiple" optionKey="id"
              optionValue="name" size="5" value="${repositoryInstance?.teams*.id}" class="many-to-many form-control"/>

</div>--}%

%{--<div class="fieldcontain ${hasErrors(bean: repositoryInstance, field: 'uniqueId', 'error')} required">--}%
%{--<label for="uniqueId">--}%
%{--<g:message code="repository.uniqueId.label" default="Unique Id"/>--}%
%{--<span class="required-indicator">*</span>--}%
%{--</label>--}%
%{--<g:textField name="uniqueId" required="" value="${repositoryInstance?.uniqueId}"/>--}%

%{--</div>--}%

