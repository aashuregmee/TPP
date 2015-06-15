<%@ page import="tpp.InternshipProject" %>



<div class="fieldcontain ${hasErrors(bean: internshipProjectInstance, field: 'projectName', 'error')} ">
	<label for="projectName">
		<g:message code="internshipProject.projectName.label" default="Project Name" />
		
	</label>
	<g:textField name="projectName" value="${internshipProjectInstance?.projectName}"/>
</div>

