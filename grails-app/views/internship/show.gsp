
<%@ page import="tpp.Internship" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'internship.label', default: 'Internship')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-internship" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-internship" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list internship">
			
				<g:if test="${internshipInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="internship.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${internshipInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${internshipInstance?.internshipProject}">
				<li class="fieldcontain">
					<span id="internshipProject-label" class="property-label"><g:message code="internship.internshipProject.label" default="Internship Project" /></span>
					
						<span class="property-value" aria-labelledby="internshipProject-label"><g:link controller="internshipProject" action="show" id="${internshipInstance?.internshipProject?.id}">${internshipInstance?.internshipProject?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${internshipInstance?.mentorName}">
				<li class="fieldcontain">
					<span id="mentorName-label" class="property-label"><g:message code="internship.mentorName.label" default="Mentor Name" /></span>
					
						<span class="property-value" aria-labelledby="mentorName-label"><g:fieldValue bean="${internshipInstance}" field="mentorName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${internshipInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="internship.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${internshipInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${internshipInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="internship.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${internshipInstance?.student?.id}">${internshipInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${internshipInstance?.id}" />
					<g:link class="edit" action="edit" id="${internshipInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
