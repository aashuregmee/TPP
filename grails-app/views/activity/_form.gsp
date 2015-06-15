<%@ page import="tpp.Activity" %>



<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="activity.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${activityInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="activity.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${activityInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="activity.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${activityInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'venue', 'error')} ">
	<label for="venue">
		<g:message code="activity.venue.label" default="Venue" />
		
	</label>
	<g:textField name="venue" value="${activityInstance?.venue}"/>
</div>

