package tpp

import org.springframework.dao.DataIntegrityViolationException

class AcademicsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [academicsInstanceList: Academics.list(params), academicsInstanceTotal: Academics.count()]
    }

    def create() {
        [academicsInstance: new Academics(params)]
    }

    def save() {
        def academicsInstance = new Academics(params)
        if (!academicsInstance.save(flush: true)) {
            render(view: "create", model: [academicsInstance: academicsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'academics.label', default: 'Academics'), academicsInstance.id])
        redirect(action: "show", id: academicsInstance.id)
    }

    def show(Long id) {
        def academicsInstance = Academics.get(id)
        if (!academicsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'academics.label', default: 'Academics'), id])
            redirect(action: "list")
            return
        }

        [academicsInstance: academicsInstance]
    }

    def edit(Long id) {
        def academicsInstance = Academics.get(id)
        if (!academicsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'academics.label', default: 'Academics'), id])
            redirect(action: "list")
            return
        }

        [academicsInstance: academicsInstance]
    }

    def update(Long id, Long version) {
        def academicsInstance = Academics.get(id)
        if (!academicsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'academics.label', default: 'Academics'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (academicsInstance.version > version) {
                academicsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'academics.label', default: 'Academics')] as Object[],
                        "Another user has updated this Academics while you were editing")
                render(view: "edit", model: [academicsInstance: academicsInstance])
                return
            }
        }

        academicsInstance.properties = params

        if (!academicsInstance.save(flush: true)) {
            render(view: "edit", model: [academicsInstance: academicsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'academics.label', default: 'Academics'), academicsInstance.id])
        redirect(action: "show", id: academicsInstance.id)
    }

    def delete(Long id) {
        def academicsInstance = Academics.get(id)
        if (!academicsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'academics.label', default: 'Academics'), id])
            redirect(action: "list")
            return
        }

        try {
            academicsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'academics.label', default: 'Academics'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'academics.label', default: 'Academics'), id])
            redirect(action: "show", id: id)
        }
    }
}
