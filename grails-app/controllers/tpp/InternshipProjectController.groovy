package tpp

import org.springframework.dao.DataIntegrityViolationException

class InternshipProjectController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [internshipProjectInstanceList: InternshipProject.list(params), internshipProjectInstanceTotal: InternshipProject.count()]
    }

    def create() {
        [internshipProjectInstance: new InternshipProject(params)]
    }

    def save() {
        def internshipProjectInstance = new InternshipProject(params)
        if (!internshipProjectInstance.save(flush: true)) {
            render(view: "create", model: [internshipProjectInstance: internshipProjectInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), internshipProjectInstance.id])
        redirect(action: "show", id: internshipProjectInstance.id)
    }

    def show(Long id) {
        def internshipProjectInstance = InternshipProject.get(id)
        if (!internshipProjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), id])
            redirect(action: "list")
            return
        }

        [internshipProjectInstance: internshipProjectInstance]
    }

    def edit(Long id) {
        def internshipProjectInstance = InternshipProject.get(id)
        if (!internshipProjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), id])
            redirect(action: "list")
            return
        }

        [internshipProjectInstance: internshipProjectInstance]
    }

    def update(Long id, Long version) {
        def internshipProjectInstance = InternshipProject.get(id)
        if (!internshipProjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (internshipProjectInstance.version > version) {
                internshipProjectInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'internshipProject.label', default: 'InternshipProject')] as Object[],
                        "Another user has updated this InternshipProject while you were editing")
                render(view: "edit", model: [internshipProjectInstance: internshipProjectInstance])
                return
            }
        }

        internshipProjectInstance.properties = params

        if (!internshipProjectInstance.save(flush: true)) {
            render(view: "edit", model: [internshipProjectInstance: internshipProjectInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), internshipProjectInstance.id])
        redirect(action: "show", id: internshipProjectInstance.id)
    }

    def delete(Long id) {
        def internshipProjectInstance = InternshipProject.get(id)
        if (!internshipProjectInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), id])
            redirect(action: "list")
            return
        }

        try {
            internshipProjectInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'internshipProject.label', default: 'InternshipProject'), id])
            redirect(action: "show", id: id)
        }
    }
}
