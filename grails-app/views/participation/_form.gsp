<%@ page import="tpp.Participation" %>



<div class="fieldcontain ${hasErrors(bean: participationInstance, field: 'activity', 'error')} required">
	<label for="activity">
		<g:message code="participation.activity.label" default="Activity" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="activity" name="activity.id" from="${tpp.Activity.list()}" optionKey="id" required="" value="${participationInstance?.activity?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: participationInstance, field: 'remarks', 'error')} ">
	<label for="remarks">
		<g:message code="participation.remarks.label" default="Remarks" />
		
	</label>
	<g:textField name="remarks" value="${participationInstance?.remarks}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: participationInstance, field: 'semesterNo', 'error')} required">
	<label for="semesterNo">
		<g:message code="participation.semesterNo.label" default="Semester No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="semesterNo" type="number" value="${participationInstance.semesterNo}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: participationInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="participation.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${tpp.Student.list()}" optionKey="id" required="" value="${participationInstance?.student?.id}" class="many-to-one"/>
</div>

