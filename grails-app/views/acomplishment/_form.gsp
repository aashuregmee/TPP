<%@ page import="tpp.Acomplishment" %>



<div class="fieldcontain ${hasErrors(bean: acomplishmentInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="acomplishment.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${acomplishmentInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: acomplishmentInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="acomplishment.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${acomplishmentInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: acomplishmentInstance, field: 'semesterNo', 'error')} required">
	<label for="semesterNo">
		<g:message code="acomplishment.semesterNo.label" default="Semester No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="semesterNo" type="number" value="${acomplishmentInstance.semesterNo}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: acomplishmentInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="acomplishment.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${acomplishmentInstance?.title}"/>
</div>

