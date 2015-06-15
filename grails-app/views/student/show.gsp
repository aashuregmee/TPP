
<%@ page import="tpp.Student" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-student" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-student" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list student">
			
				<g:if test="${studentInstance?.academics}">
				<li class="fieldcontain">
					<span id="academics-label" class="property-label"><g:message code="student.academics.label" default="Academics" /></span>
					
						<g:each in="${studentInstance.academics}" var="a">
						<span class="property-value" aria-labelledby="academics-label"><g:link controller="academics" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.participation}">
				<li class="fieldcontain">
					<span id="participation-label" class="property-label"><g:message code="student.participation.label" default="Participation" /></span>
					
						<g:each in="${studentInstance.participation}" var="p">
						<span class="property-value" aria-labelledby="participation-label"><g:link controller="participation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.awards}">
				<li class="fieldcontain">
					<span id="awards-label" class="property-label"><g:message code="student.awards.label" default="Awards" /></span>
					
						<g:each in="${studentInstance.awards}" var="a">
						<span class="property-value" aria-labelledby="awards-label"><g:link controller="awards" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.batch}">
				<li class="fieldcontain">
					<span id="batch-label" class="property-label"><g:message code="student.batch.label" default="Batch" /></span>
					
						<span class="property-value" aria-labelledby="batch-label"><g:fieldValue bean="${studentInstance}" field="batch"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.collegeApplicationFormPath}">
				<li class="fieldcontain">
					<span id="collegeApplicationFormPath-label" class="property-label"><g:message code="student.collegeApplicationFormPath.label" default="College Application Form Path" /></span>
					
						<span class="property-value" aria-labelledby="collegeApplicationFormPath-label"><g:fieldValue bean="${studentInstance}" field="collegeApplicationFormPath"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.currentSemesterNo}">
				<li class="fieldcontain">
					<span id="currentSemesterNo-label" class="property-label"><g:message code="student.currentSemesterNo.label" default="Current Semester No" /></span>
					
						<span class="property-value" aria-labelledby="currentSemesterNo-label"><g:fieldValue bean="${studentInstance}" field="currentSemesterNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="student.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${studentInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="student.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${studentInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="student.middleName.label" default="Middle Name" /></span>
					
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${studentInstance}" field="middleName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studentInstance?.rollNo}">
				<li class="fieldcontain">
					<span id="rollNo-label" class="property-label"><g:message code="student.rollNo.label" default="Roll No" /></span>
					
						<span class="property-value" aria-labelledby="rollNo-label"><g:fieldValue bean="${studentInstance}" field="rollNo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${studentInstance?.id}" />
					<g:link class="edit" action="edit" id="${studentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
