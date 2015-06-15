<%@ page import="tpp.Award" %>



<div class="fieldcontain ${hasErrors(bean: awardInstance, field: 'awards', 'error')} ">
	<label for="awards">
		<g:message code="award.awards.label" default="Awards" />
		
	</label>
	<g:select name="awards" from="${tpp.Awards.list()}" multiple="multiple" optionKey="id" size="5" value="${awardInstance?.awards*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: awardInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="award.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${awardInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: awardInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="award.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${awardInstance?.title}"/>
</div>

