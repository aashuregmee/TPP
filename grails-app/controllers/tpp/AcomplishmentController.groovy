package tpp

import org.springframework.dao.DataIntegrityViolationException

class AcomplishmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [acomplishmentInstanceList: Acomplishment.list(params), acomplishmentInstanceTotal: Acomplishment.count()]
    }

    def create() {
        [acomplishmentInstance: new Acomplishment(params)]
    }

    def save() {
        def acomplishmentInstance = new Acomplishment(params)
        if (!acomplishmentInstance.save(flush: true)) {
            render(view: "create", model: [acomplishmentInstance: acomplishmentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), acomplishmentInstance.id])
        redirect(action: "show", id: acomplishmentInstance.id)
    }

    def show(Long id) {
        def acomplishmentInstance = Acomplishment.get(id)
        if (!acomplishmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), id])
            redirect(action: "list")
            return
        }

        [acomplishmentInstance: acomplishmentInstance]
    }

    def edit(Long id) {
        def acomplishmentInstance = Acomplishment.get(id)
        if (!acomplishmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), id])
            redirect(action: "list")
            return
        }

        [acomplishmentInstance: acomplishmentInstance]
    }

    def update(Long id, Long version) {
        def acomplishmentInstance = Acomplishment.get(id)
        if (!acomplishmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (acomplishmentInstance.version > version) {
                acomplishmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'acomplishment.label', default: 'Acomplishment')] as Object[],
                          "Another user has updated this Acomplishment while you were editing")
                render(view: "edit", model: [acomplishmentInstance: acomplishmentInstance])
                return
            }
        }

        acomplishmentInstance.properties = params

        if (!acomplishmentInstance.save(flush: true)) {
            render(view: "edit", model: [acomplishmentInstance: acomplishmentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), acomplishmentInstance.id])
        redirect(action: "show", id: acomplishmentInstance.id)
    }

    def delete(Long id) {
        def acomplishmentInstance = Acomplishment.get(id)
        if (!acomplishmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), id])
            redirect(action: "list")
            return
        }

        try {
            acomplishmentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'acomplishment.label', default: 'Acomplishment'), id])
            redirect(action: "show", id: id)
        }
    }
}
