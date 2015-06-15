
<%@ page import="tpp.Awards" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'awards.label', default: 'Awards')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-awards" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-awards" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list awards">
			
				<g:if test="${awardsInstance?.award}">
				<li class="fieldcontain">
					<span id="award-label" class="property-label"><g:message code="awards.award.label" default="Award" /></span>
					
						<span class="property-value" aria-labelledby="award-label"><g:link controller="awards" action="show" id="${awardsInstance?.award?.id}">${awardsInstance?.award?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${awardsInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="awards.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${awardsInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${awardsInstance?.remarks}">
				<li class="fieldcontain">
					<span id="remarks-label" class="property-label"><g:message code="awards.remarks.label" default="Remarks" /></span>
					
						<span class="property-value" aria-labelledby="remarks-label"><g:fieldValue bean="${awardsInstance}" field="remarks"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${awardsInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="awards.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${awardsInstance?.student?.id}">${awardsInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${awardsInstance?.id}" />
					<g:link class="edit" action="edit" id="${awardsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
