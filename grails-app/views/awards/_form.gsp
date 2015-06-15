<%@ page import="tpp.Awards" %>



<div class="fieldcontain ${hasErrors(bean: awardsInstance, field: 'award', 'error')} required">
	<label for="award">
		<g:message code="awards.award.label" default="Award" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="award" name="award.id" from="${tpp.Awards.list()}" optionKey="id" required="" value="${awardsInstance?.award?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: awardsInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="awards.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${awardsInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: awardsInstance, field: 'remarks', 'error')} ">
	<label for="remarks">
		<g:message code="awards.remarks.label" default="Remarks" />
		
	</label>
	<g:textField name="remarks" value="${awardsInstance?.remarks}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: awardsInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="awards.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${tpp.Student.list()}" optionKey="id" required="" value="${awardsInstance?.student?.id}" class="many-to-one"/>
</div>

