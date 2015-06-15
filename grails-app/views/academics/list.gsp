
<%@ page import="tpp.Academics" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'academics.label', default: 'Academics')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-academics" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-academics" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="academics.student.label" default="Student" /></th>
					
						<g:sortableColumn property="adminComment" title="${message(code: 'academics.adminComment.label', default: 'Admin Comment')}" />
					
						<g:sortableColumn property="semesterNo" title="${message(code: 'academics.semesterNo.label', default: 'Semester No')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${academicsInstanceList}" status="i" var="academicsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${academicsInstance.id}">${fieldValue(bean: academicsInstance, field: "student")}</g:link></td>
					
						<td>${fieldValue(bean: academicsInstance, field: "adminComment")}</td>
					
						<td>${fieldValue(bean: academicsInstance, field: "semesterNo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${academicsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
