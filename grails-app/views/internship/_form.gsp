<%@ page import="tpp.Internship" %>



<div class="fieldcontain ${hasErrors(bean: internshipInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="internship.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${internshipInstance?.endDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: internshipInstance, field: 'internshipProject', 'error')} required">
	<label for="internshipProject">
		<g:message code="internship.internshipProject.label" default="Internship Project" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="internshipProject" name="internshipProject.id" from="${tpp.InternshipProject.list()}" optionKey="id" required="" value="${internshipInstance?.internshipProject?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: internshipInstance, field: 'mentorName', 'error')} ">
	<label for="mentorName">
		<g:message code="internship.mentorName.label" default="Mentor Name" />
		
	</label>
	<g:textField name="mentorName" value="${internshipInstance?.mentorName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: internshipInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="internship.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${internshipInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: internshipInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="internship.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${tpp.Student.list()}" optionKey="id" required="" value="${internshipInstance?.student?.id}" class="many-to-one"/>
</div>

