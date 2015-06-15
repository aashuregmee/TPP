<%@ page import="tpp.Subject" %>



<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="subject.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${subjectInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subjectInstance, field: 'semesterNo', 'error')} required">
	<label for="semesterNo">
		<g:message code="subject.semesterNo.label" default="Semester No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="semesterNo" type="number" value="${subjectInstance.semesterNo}" required=""/>
</div>

