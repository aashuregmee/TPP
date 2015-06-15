package tpp

import org.springframework.dao.DataIntegrityViolationException

class ParticipationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [participationInstanceList: Participation.list(params), participationInstanceTotal: Participation.count()]
    }

    def create() {
        [participationInstance: new Participation(params)]
    }

    def save() {
        def participationInstance = new Participation(params)
        if (!participationInstance.save(flush: true)) {
            render(view: "create", model: [participationInstance: participationInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'participation.label', default: 'Participation'), participationInstance.id])
        redirect(action: "show", id: participationInstance.id)
    }

    def show(Long id) {
        def participationInstance = Participation.get(id)
        if (!participationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'participation.label', default: 'Participation'), id])
            redirect(action: "list")
            return
        }

        [participationInstance: participationInstance]
    }

    def edit(Long id) {
        def participationInstance = Participation.get(id)
        if (!participationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'participation.label', default: 'Participation'), id])
            redirect(action: "list")
            return
        }

        [participationInstance: participationInstance]
    }

    def update(Long id, Long version) {
        def participationInstance = Participation.get(id)
        if (!participationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'participation.label', default: 'Participation'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (participationInstance.version > version) {
                participationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'participation.label', default: 'Participation')] as Object[],
                        "Another user has updated this Participation while you were editing")
                render(view: "edit", model: [participationInstance: participationInstance])
                return
            }
        }

        participationInstance.properties = params

        if (!participationInstance.save(flush: true)) {
            render(view: "edit", model: [participationInstance: participationInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'participation.label', default: 'Participation'), participationInstance.id])
        redirect(action: "show", id: participationInstance.id)
    }

    def delete(Long id) {
        def participationInstance = Participation.get(id)
        if (!participationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'participation.label', default: 'Participation'), id])
            redirect(action: "list")
            return
        }

        try {
            participationInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'participation.label', default: 'Participation'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'participation.label', default: 'Participation'), id])
            redirect(action: "show", id: id)
        }
    }
}
