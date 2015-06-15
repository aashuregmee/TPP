package tpp

import org.springframework.dao.DataIntegrityViolationException

class AwardsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [awardsInstanceList: Awards.list(params), awardsInstanceTotal: Awards.count()]
    }

    def create() {
        [awardsInstance: new Awards(params)]
    }

    def save() {
        def awardsInstance = new Awards(params)
        if (!awardsInstance.save(flush: true)) {
            render(view: "create", model: [awardsInstance: awardsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'awards.label', default: 'Awards'), awardsInstance.id])
        redirect(action: "show", id: awardsInstance.id)
    }

    def show(Long id) {
        def awardsInstance = Awards.get(id)
        if (!awardsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'awards.label', default: 'Awards'), id])
            redirect(action: "list")
            return
        }

        [awardsInstance: awardsInstance]
    }

    def edit(Long id) {
        def awardsInstance = Awards.get(id)
        if (!awardsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'awards.label', default: 'Awards'), id])
            redirect(action: "list")
            return
        }

        [awardsInstance: awardsInstance]
    }

    def update(Long id, Long version) {
        def awardsInstance = Awards.get(id)
        if (!awardsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'awards.label', default: 'Awards'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (awardsInstance.version > version) {
                awardsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'awards.label', default: 'Awards')] as Object[],
                        "Another user has updated this Awards while you were editing")
                render(view: "edit", model: [awardsInstance: awardsInstance])
                return
            }
        }

        awardsInstance.properties = params

        if (!awardsInstance.save(flush: true)) {
            render(view: "edit", model: [awardsInstance: awardsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'awards.label', default: 'Awards'), awardsInstance.id])
        redirect(action: "show", id: awardsInstance.id)
    }

    def delete(Long id) {
        def awardsInstance = Awards.get(id)
        if (!awardsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'awards.label', default: 'Awards'), id])
            redirect(action: "list")
            return
        }

        try {
            awardsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'awards.label', default: 'Awards'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'awards.label', default: 'Awards'), id])
            redirect(action: "show", id: id)
        }
    }
}
