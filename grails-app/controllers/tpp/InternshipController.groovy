package tpp

import org.springframework.dao.DataIntegrityViolationException

class InternshipController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [internshipInstanceList: Internship.list(params), internshipInstanceTotal: Internship.count()]
    }

    def create() {
        [internshipInstance: new Internship(params)]
    }

    def save() {
        def internshipInstance = new Internship(params)
        if (!internshipInstance.save(flush: true)) {
            render(view: "create", model: [internshipInstance: internshipInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'internship.label', default: 'Internship'), internshipInstance.id])
        redirect(action: "show", id: internshipInstance.id)
    }

    def show(Long id) {
        def internshipInstance = Internship.get(id)
        if (!internshipInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internship.label', default: 'Internship'), id])
            redirect(action: "list")
            return
        }

        [internshipInstance: internshipInstance]
    }

    def edit(Long id) {
        def internshipInstance = Internship.get(id)
        if (!internshipInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internship.label', default: 'Internship'), id])
            redirect(action: "list")
            return
        }

        [internshipInstance: internshipInstance]
    }

    def update(Long id, Long version) {
        def internshipInstance = Internship.get(id)
        if (!internshipInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internship.label', default: 'Internship'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (internshipInstance.version > version) {
                internshipInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'internship.label', default: 'Internship')] as Object[],
                        "Another user has updated this Internship while you were editing")
                render(view: "edit", model: [internshipInstance: internshipInstance])
                return
            }
        }

        internshipInstance.properties = params

        if (!internshipInstance.save(flush: true)) {
            render(view: "edit", model: [internshipInstance: internshipInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'internship.label', default: 'Internship'), internshipInstance.id])
        redirect(action: "show", id: internshipInstance.id)
    }

    def delete(Long id) {
        def internshipInstance = Internship.get(id)
        if (!internshipInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internship.label', default: 'Internship'), id])
            redirect(action: "list")
            return
        }

        try {
            internshipInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'internship.label', default: 'Internship'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'internship.label', default: 'Internship'), id])
            redirect(action: "show", id: id)
        }
    }
}
