package tpp

import org.springframework.dao.DataIntegrityViolationException

class SubjectController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [subjectInstanceList: Subject.list(params), subjectInstanceTotal: Subject.count()]
    }

    def create() {
        [subjectInstance: new Subject(params)]
    }

    def save() {
        def subjectInstance = new Subject(params)
        if (!subjectInstance.save(flush: true)) {
            render(view: "create", model: [subjectInstance: subjectInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'subject.label', default: 'Subject'), subjectInstance.id])
        redirect(action: "show", id: subjectInstance.id)
    }

    def show(Long id) {
        def subjectInstance = Subject.get(id)
        if (!subjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), id])
            redirect(action: "list")
            return
        }

        [subjectInstance: subjectInstance]
    }

    def edit(Long id) {
        def subjectInstance = Subject.get(id)
        if (!subjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), id])
            redirect(action: "list")
            return
        }

        [subjectInstance: subjectInstance]
    }

    def update(Long id, Long version) {
        def subjectInstance = Subject.get(id)
        if (!subjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (subjectInstance.version > version) {
                subjectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'subject.label', default: 'Subject')] as Object[],
                        "Another user has updated this Subject while you were editing")
                render(view: "edit", model: [subjectInstance: subjectInstance])
                return
            }
        }

        subjectInstance.properties = params

        if (!subjectInstance.save(flush: true)) {
            render(view: "edit", model: [subjectInstance: subjectInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'subject.label', default: 'Subject'), subjectInstance.id])
        redirect(action: "show", id: subjectInstance.id)
    }

    def delete(Long id) {
        def subjectInstance = Subject.get(id)
        if (!subjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), id])
            redirect(action: "list")
            return
        }

        try {
            subjectInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'subject.label', default: 'Subject'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'subject.label', default: 'Subject'), id])
            redirect(action: "show", id: id)
        }
    }
}
