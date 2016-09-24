
<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-repository" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-repository" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list repository">
			
				<g:if test="${repositoryInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="repository.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${repositoryInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="repository.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${repositoryInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.accessLevel}">
				<li class="fieldcontain">
					<span id="accessLevel-label" class="property-label"><g:message code="repository.accessLevel.label" default="Access Level" /></span>
					
						<span class="property-value" aria-labelledby="accessLevel-label"><g:fieldValue bean="${repositoryInstance}" field="accessLevel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="repository.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${repositoryInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.isDeleted}">
				<li class="fieldcontain">
					<span id="isDeleted-label" class="property-label"><g:message code="repository.isDeleted.label" default="Is Deleted" /></span>
					
						<span class="property-value" aria-labelledby="isDeleted-label"><g:formatBoolean boolean="${repositoryInstance?.isDeleted}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="repository.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${repositoryInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.objectStatus}">
				<li class="fieldcontain">
					<span id="objectStatus-label" class="property-label"><g:message code="repository.objectStatus.label" default="Object Status" /></span>
					
						<span class="property-value" aria-labelledby="objectStatus-label"><g:fieldValue bean="${repositoryInstance}" field="objectStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="repository.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="user" action="show" id="${repositoryInstance?.owner?.id}">${repositoryInstance?.owner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.teams}">
				<li class="fieldcontain">
					<span id="teams-label" class="property-label"><g:message code="repository.teams.label" default="Teams" /></span>
					
						<g:each in="${repositoryInstance.teams}" var="t">
						<span class="property-value" aria-labelledby="teams-label"><g:link controller="team" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${repositoryInstance?.uniqueId}">
				<li class="fieldcontain">
					<span id="uniqueId-label" class="property-label"><g:message code="repository.uniqueId.label" default="Unique Id" /></span>
					
						<span class="property-value" aria-labelledby="uniqueId-label"><g:fieldValue bean="${repositoryInstance}" field="uniqueId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:repositoryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${repositoryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
