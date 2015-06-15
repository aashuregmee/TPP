<%@ page import="tpp.Academics" %>



<div class="fieldcontain ${hasErrors(bean: academicsInstance, field: 'student', 'error')} ">
	<label for="student">
		<g:message code="academics.student.label" default="Student" />
		
	</label>
	<g:select id="student" name="student.id" from="${tpp.Student.list()}" optionKey="id" value="${academicsInstance?.student?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicsInstance, field: 'adminComment', 'error')} ">
	<label for="adminComment">
		<g:message code="academics.adminComment.label" default="Admin Comment" />
		
	</label>
	<g:textField name="adminComment" value="${academicsInstance?.adminComment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicsInstance, field: 'semesterNo', 'error')} required">
	<label for="semesterNo">
		<g:message code="academics.semesterNo.label" default="Semester No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="semesterNo" type="number" value="${academicsInstance.semesterNo}" required=""/>
</div>

