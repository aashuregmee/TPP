package tpp


import org.junit.*
import grails.test.mixin.*

@TestFor(AcomplishmentController)
@Mock(Acomplishment)
class AcomplishmentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/acomplishment/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.acomplishmentInstanceList.size() == 0
        assert model.acomplishmentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.acomplishmentInstance != null
    }

    void testSave() {
        controller.save()

        assert model.acomplishmentInstance != null
        assert view == '/acomplishment/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/acomplishment/show/1'
        assert controller.flash.message != null
        assert Acomplishment.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/acomplishment/list'

        populateValidParams(params)
        def acomplishment = new Acomplishment(params)

        assert acomplishment.save() != null

        params.id = acomplishment.id

        def model = controller.show()

        assert model.acomplishmentInstance == acomplishment
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/acomplishment/list'

        populateValidParams(params)
        def acomplishment = new Acomplishment(params)

        assert acomplishment.save() != null

        params.id = acomplishment.id

        def model = controller.edit()

        assert model.acomplishmentInstance == acomplishment
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/acomplishment/list'

        response.reset()

        populateValidParams(params)
        def acomplishment = new Acomplishment(params)

        assert acomplishment.save() != null

        // test invalid parameters in update
        params.id = acomplishment.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/acomplishment/edit"
        assert model.acomplishmentInstance != null

        acomplishment.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/acomplishment/show/$acomplishment.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        acomplishment.clearErrors()

        populateValidParams(params)
        params.id = acomplishment.id
        params.version = -1
        controller.update()

        assert view == "/acomplishment/edit"
        assert model.acomplishmentInstance != null
        assert model.acomplishmentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/acomplishment/list'

        response.reset()

        populateValidParams(params)
        def acomplishment = new Acomplishment(params)

        assert acomplishment.save() != null
        assert Acomplishment.count() == 1

        params.id = acomplishment.id

        controller.delete()

        assert Acomplishment.count() == 0
        assert Acomplishment.get(acomplishment.id) == null
        assert response.redirectedUrl == '/acomplishment/list'
    }
}
