
<%@ page import="tpp.Internship" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'internship.label', default: 'Internship')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-internship" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-internship" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="endDate" title="${message(code: 'internship.endDate.label', default: 'End Date')}" />
					
						<th><g:message code="internship.internshipProject.label" default="Internship Project" /></th>
					
						<g:sortableColumn property="mentorName" title="${message(code: 'internship.mentorName.label', default: 'Mentor Name')}" />
					
						<g:sortableColumn property="startDate" title="${message(code: 'internship.startDate.label', default: 'Start Date')}" />
					
						<th><g:message code="internship.student.label" default="Student" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${internshipInstanceList}" status="i" var="internshipInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${internshipInstance.id}">${fieldValue(bean: internshipInstance, field: "endDate")}</g:link></td>
					
						<td>${fieldValue(bean: internshipInstance, field: "internshipProject")}</td>
					
						<td>${fieldValue(bean: internshipInstance, field: "mentorName")}</td>
					
						<td><g:formatDate date="${internshipInstance.startDate}" /></td>
					
						<td>${fieldValue(bean: internshipInstance, field: "student")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${internshipInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
