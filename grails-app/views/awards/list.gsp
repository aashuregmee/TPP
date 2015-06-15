
<%@ page import="tpp.Awards" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'awards.label', default: 'Awards')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-awards" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-awards" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="awards.award.label" default="Award" /></th>
					
						<g:sortableColumn property="date" title="${message(code: 'awards.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="remarks" title="${message(code: 'awards.remarks.label', default: 'Remarks')}" />
					
						<th><g:message code="awards.student.label" default="Student" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${awardsInstanceList}" status="i" var="awardsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${awardsInstance.id}">${fieldValue(bean: awardsInstance, field: "award")}</g:link></td>
					
						<td><g:formatDate date="${awardsInstance.date}" /></td>
					
						<td>${fieldValue(bean: awardsInstance, field: "remarks")}</td>
					
						<td>${fieldValue(bean: awardsInstance, field: "student")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${awardsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
