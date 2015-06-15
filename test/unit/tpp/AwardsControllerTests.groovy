package tpp


import org.junit.*
import grails.test.mixin.*

@TestFor(AwardsController)
@Mock(Awards)
class AwardsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/awards/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.awardsInstanceList.size() == 0
        assert model.awardsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.awardsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.awardsInstance != null
        assert view == '/awards/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/awards/show/1'
        assert controller.flash.message != null
        assert Awards.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/awards/list'

        populateValidParams(params)
        def awards = new Awards(params)

        assert awards.save() != null

        params.id = awards.id

        def model = controller.show()

        assert model.awardsInstance == awards
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/awards/list'

        populateValidParams(params)
        def awards = new Awards(params)

        assert awards.save() != null

        params.id = awards.id

        def model = controller.edit()

        assert model.awardsInstance == awards
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/awards/list'

        response.reset()

        populateValidParams(params)
        def awards = new Awards(params)

        assert awards.save() != null

        // test invalid parameters in update
        params.id = awards.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/awards/edit"
        assert model.awardsInstance != null

        awards.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/awards/show/$awards.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        awards.clearErrors()

        populateValidParams(params)
        params.id = awards.id
        params.version = -1
        controller.update()

        assert view == "/awards/edit"
        assert model.awardsInstance != null
        assert model.awardsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/awards/list'

        response.reset()

        populateValidParams(params)
        def awards = new Awards(params)

        assert awards.save() != null
        assert Awards.count() == 1

        params.id = awards.id

        controller.delete()

        assert Awards.count() == 0
        assert Awards.get(awards.id) == null
        assert response.redirectedUrl == '/awards/list'
    }
}
