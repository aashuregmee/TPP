package tpp

import org.springframework.dao.DataIntegrityViolationException

class AwardController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [awardInstanceList: Award.list(params), awardInstanceTotal: Award.count()]
    }

    def create() {
        [awardInstance: new Award(params)]
    }

    def save() {
        def awardInstance = new Award(params)
        if (!awardInstance.save(flush: true)) {
            render(view: "create", model: [awardInstance: awardInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'award.label', default: 'Award'), awardInstance.id])
        redirect(action: "show", id: awardInstance.id)
    }

    def show(Long id) {
        def awardInstance = Award.get(id)
        if (!awardInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'award.label', default: 'Award'), id])
            redirect(action: "list")
            return
        }

        [awardInstance: awardInstance]
    }

    def edit(Long id) {
        def awardInstance = Award.get(id)
        if (!awardInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'award.label', default: 'Award'), id])
            redirect(action: "list")
            return
        }

        [awardInstance: awardInstance]
    }

    def update(Long id, Long version) {
        def awardInstance = Award.get(id)
        if (!awardInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'award.label', default: 'Award'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (awardInstance.version > version) {
                awardInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'award.label', default: 'Award')] as Object[],
                        "Another user has updated this Award while you were editing")
                render(view: "edit", model: [awardInstance: awardInstance])
                return
            }
        }

        awardInstance.properties = params

        if (!awardInstance.save(flush: true)) {
            render(view: "edit", model: [awardInstance: awardInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'award.label', default: 'Award'), awardInstance.id])
        redirect(action: "show", id: awardInstance.id)
    }

    def delete(Long id) {
        def awardInstance = Award.get(id)
        if (!awardInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'award.label', default: 'Award'), id])
            redirect(action: "list")
            return
        }

        try {
            awardInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'award.label', default: 'Award'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'award.label', default: 'Award'), id])
            redirect(action: "show", id: id)
        }
    }
}
