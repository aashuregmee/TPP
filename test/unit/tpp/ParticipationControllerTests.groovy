package tpp


import org.junit.*
import grails.test.mixin.*

@TestFor(ParticipationController)
@Mock(Participation)
class ParticipationControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/participation/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.participationInstanceList.size() == 0
        assert model.participationInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.participationInstance != null
    }

    void testSave() {
        controller.save()

        assert model.participationInstance != null
        assert view == '/participation/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/participation/show/1'
        assert controller.flash.message != null
        assert Participation.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/participation/list'

        populateValidParams(params)
        def participation = new Participation(params)

        assert participation.save() != null

        params.id = participation.id

        def model = controller.show()

        assert model.participationInstance == participation
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/participation/list'

        populateValidParams(params)
        def participation = new Participation(params)

        assert participation.save() != null

        params.id = participation.id

        def model = controller.edit()

        assert model.participationInstance == participation
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/participation/list'

        response.reset()

        populateValidParams(params)
        def participation = new Participation(params)

        assert participation.save() != null

        // test invalid parameters in update
        params.id = participation.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/participation/edit"
        assert model.participationInstance != null

        participation.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/participation/show/$participation.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        participation.clearErrors()

        populateValidParams(params)
        params.id = participation.id
        params.version = -1
        controller.update()

        assert view == "/participation/edit"
        assert model.participationInstance != null
        assert model.participationInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/participation/list'

        response.reset()

        populateValidParams(params)
        def participation = new Participation(params)

        assert participation.save() != null
        assert Participation.count() == 1

        params.id = participation.id

        controller.delete()

        assert Participation.count() == 0
        assert Participation.get(participation.id) == null
        assert response.redirectedUrl == '/participation/list'
    }
}
