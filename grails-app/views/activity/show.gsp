
<%@ page import="tpp.Activity" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activity.label', default: 'Activity')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-activity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-activity" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list activity">
			
				<g:if test="${activityInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="activity.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${activityInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="activity.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${activityInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="activity.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${activityInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityInstance?.venue}">
				<li class="fieldcontain">
					<span id="venue-label" class="property-label"><g:message code="activity.venue.label" default="Venue" /></span>
					
						<span class="property-value" aria-labelledby="venue-label"><g:fieldValue bean="${activityInstance}" field="venue"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${activityInstance?.id}" />
					<g:link class="edit" action="edit" id="${activityInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
