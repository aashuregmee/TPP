<%@ page import="tpp.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'academics', 'error')} ">
	<label for="academics">
		<g:message code="student.academics.label" default="Academics" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.academics?}" var="a">
    <li><g:link controller="academics" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="academics" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'academics.label', default: 'Academics')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'participation', 'error')} ">
	<label for="participation">
		<g:message code="student.participation.label" default="Participation" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.participation?}" var="p">
    <li><g:link controller="participation" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="participation" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'participation.label', default: 'Participation')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'awards', 'error')} ">
	<label for="awards">
		<g:message code="student.awards.label" default="Awards" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.awards?}" var="a">
    <li><g:link controller="awards" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="awards" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'awards.label', default: 'Awards')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'batch', 'error')} ">
	<label for="batch">
		<g:message code="student.batch.label" default="Batch" />
		
	</label>
	<g:textField name="batch" value="${studentInstance?.batch}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'collegeApplicationFormPath', 'error')} ">
	<label for="collegeApplicationFormPath">
		<g:message code="student.collegeApplicationFormPath.label" default="College Application Form Path" />
		
	</label>
	<g:textField name="collegeApplicationFormPath" value="${studentInstance?.collegeApplicationFormPath}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'currentSemesterNo', 'error')} required">
	<label for="currentSemesterNo">
		<g:message code="student.currentSemesterNo.label" default="Current Semester No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="currentSemesterNo" type="number" value="${studentInstance.currentSemesterNo}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="student.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${studentInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="student.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${studentInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="student.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${studentInstance?.middleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'rollNo', 'error')} ">
	<label for="rollNo">
		<g:message code="student.rollNo.label" default="Roll No" />
		
	</label>
	<g:textField name="rollNo" value="${studentInstance?.rollNo}"/>
</div>

