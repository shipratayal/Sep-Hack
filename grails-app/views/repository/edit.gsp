<%@ page import="com.nexthoughts.issuetracker.Repository" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="user"/>
    <g:set var="entityName" value="${message(code: 'repository.label', default: 'Repository')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
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
                        <li><g:link class="list btn btn-primary" action="index"><g:message code="default.list.label"
                                                                                           args="[entityName]"/></g:link></li>
                    </div>

                    <div class="col-md-1">
                        <li><g:link class="create btn btn-primary" action="create"><g:message code="default.new.label"
                                                                                              args="[entityName]"/></g:link></li>
                    </div>
                </div>
                
            </div>

            <div id="edit-repository" class="content scaffold-edit" role="main">
                <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:hasErrors bean="${repositoryInstance}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${repositoryInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                    error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
                <g:form url="[resource: repositoryInstance, action: 'update']" method="PUT">
                    <g:hiddenField name="version" value="${repositoryInstance?.version}"/>
                    <fieldset class="form">
                        <g:render template="form"/>
                    </fieldset>
                    <fieldset class="buttons">
                        <g:actionSubmit class="save" action="update"
                                        value="${message(code: 'default.button.update.label', default: 'Update')}"/>
                    </fieldset>
                </g:form>
            </div>
        </div>

    </div>

</div>

</body>
</html>
