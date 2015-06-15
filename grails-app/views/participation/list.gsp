
<%@ page import="tpp.Participation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'participation.label', default: 'Participation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-participation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-participation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="participation.activity.label" default="Activity" /></th>
					
						<g:sortableColumn property="remarks" title="${message(code: 'participation.remarks.label', default: 'Remarks')}" />
					
						<g:sortableColumn property="semesterNo" title="${message(code: 'participation.semesterNo.label', default: 'Semester No')}" />
					
						<th><g:message code="participation.student.label" default="Student" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${participationInstanceList}" status="i" var="participationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${participationInstance.id}">${fieldValue(bean: participationInstance, field: "activity")}</g:link></td>
					
						<td>${fieldValue(bean: participationInstance, field: "remarks")}</td>
					
						<td>${fieldValue(bean: participationInstance, field: "semesterNo")}</td>
					
						<td>${fieldValue(bean: participationInstance, field: "student")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${participationInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
