
<%@ page import="tpp.Acomplishment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'acomplishment.label', default: 'Acomplishment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-acomplishment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-acomplishment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list acomplishment">
			
				<g:if test="${acomplishmentInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="acomplishment.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${acomplishmentInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${acomplishmentInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="acomplishment.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${acomplishmentInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acomplishmentInstance?.semesterNo}">
				<li class="fieldcontain">
					<span id="semesterNo-label" class="property-label"><g:message code="acomplishment.semesterNo.label" default="Semester No" /></span>
					
						<span class="property-value" aria-labelledby="semesterNo-label"><g:fieldValue bean="${acomplishmentInstance}" field="semesterNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${acomplishmentInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="acomplishment.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${acomplishmentInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${acomplishmentInstance?.id}" />
					<g:link class="edit" action="edit" id="${acomplishmentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
