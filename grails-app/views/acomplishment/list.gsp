
<%@ page import="tpp.Acomplishment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'acomplishment.label', default: 'Acomplishment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-acomplishment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-acomplishment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="date" title="${message(code: 'acomplishment.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'acomplishment.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="semesterNo" title="${message(code: 'acomplishment.semesterNo.label', default: 'Semester No')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'acomplishment.title.label', default: 'Title')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${acomplishmentInstanceList}" status="i" var="acomplishmentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${acomplishmentInstance.id}">${fieldValue(bean: acomplishmentInstance, field: "date")}</g:link></td>
					
						<td>${fieldValue(bean: acomplishmentInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: acomplishmentInstance, field: "semesterNo")}</td>
					
						<td>${fieldValue(bean: acomplishmentInstance, field: "title")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${acomplishmentInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
