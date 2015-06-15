
<%@ page import="tpp.Academics" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'academics.label', default: 'Academics')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-academics" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-academics" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list academics">
			
				<g:if test="${academicsInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="academics.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${academicsInstance?.student?.id}">${academicsInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicsInstance?.adminComment}">
				<li class="fieldcontain">
					<span id="adminComment-label" class="property-label"><g:message code="academics.adminComment.label" default="Admin Comment" /></span>
					
						<span class="property-value" aria-labelledby="adminComment-label"><g:fieldValue bean="${academicsInstance}" field="adminComment"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicsInstance?.semesterNo}">
				<li class="fieldcontain">
					<span id="semesterNo-label" class="property-label"><g:message code="academics.semesterNo.label" default="Semester No" /></span>
					
						<span class="property-value" aria-labelledby="semesterNo-label"><g:fieldValue bean="${academicsInstance}" field="semesterNo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${academicsInstance?.id}" />
					<g:link class="edit" action="edit" id="${academicsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
