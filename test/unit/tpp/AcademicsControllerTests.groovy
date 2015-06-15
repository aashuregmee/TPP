package tpp



import org.junit.*
import grails.test.mixin.*

@TestFor(AcademicsController)
@Mock(Academics)
class AcademicsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/academics/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.academicsInstanceList.size() == 0
        assert model.academicsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.academicsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.academicsInstance != null
        assert view == '/academics/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/academics/show/1'
        assert controller.flash.message != null
        assert Academics.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/academics/list'

        populateValidParams(params)
        def academics = new Academics(params)

        assert academics.save() != null

        params.id = academics.id

        def model = controller.show()

        assert model.academicsInstance == academics
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/academics/list'

        populateValidParams(params)
        def academics = new Academics(params)

        assert academics.save() != null

        params.id = academics.id

        def model = controller.edit()

        assert model.academicsInstance == academics
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/academics/list'

        response.reset()

        populateValidParams(params)
        def academics = new Academics(params)

        assert academics.save() != null

        // test invalid parameters in update
        params.id = academics.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/academics/edit"
        assert model.academicsInstance != null

        academics.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/academics/show/$academics.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        academics.clearErrors()

        populateValidParams(params)
        params.id = academics.id
        params.version = -1
        controller.update()

        assert view == "/academics/edit"
        assert model.academicsInstance != null
        assert model.academicsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/academics/list'

        response.reset()

        populateValidParams(params)
        def academics = new Academics(params)

        assert academics.save() != null
        assert Academics.count() == 1

        params.id = academics.id

        controller.delete()

        assert Academics.count() == 0
        assert Academics.get(academics.id) == null
        assert response.redirectedUrl == '/academics/list'
    }
}
