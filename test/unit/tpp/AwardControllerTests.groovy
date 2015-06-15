package tpp


import org.junit.*
import grails.test.mixin.*

@TestFor(AwardController)
@Mock(Award)
class AwardControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/award/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.awardInstanceList.size() == 0
        assert model.awardInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.awardInstance != null
    }

    void testSave() {
        controller.save()

        assert model.awardInstance != null
        assert view == '/award/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/award/show/1'
        assert controller.flash.message != null
        assert Award.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/award/list'

        populateValidParams(params)
        def award = new Award(params)

        assert award.save() != null

        params.id = award.id

        def model = controller.show()

        assert model.awardInstance == award
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/award/list'

        populateValidParams(params)
        def award = new Award(params)

        assert award.save() != null

        params.id = award.id

        def model = controller.edit()

        assert model.awardInstance == award
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/award/list'

        response.reset()

        populateValidParams(params)
        def award = new Award(params)

        assert award.save() != null

        // test invalid parameters in update
        params.id = award.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/award/edit"
        assert model.awardInstance != null

        award.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/award/show/$award.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        award.clearErrors()

        populateValidParams(params)
        params.id = award.id
        params.version = -1
        controller.update()

        assert view == "/award/edit"
        assert model.awardInstance != null
        assert model.awardInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/award/list'

        response.reset()

        populateValidParams(params)
        def award = new Award(params)

        assert award.save() != null
        assert Award.count() == 1

        params.id = award.id

        controller.delete()

        assert Award.count() == 0
        assert Award.get(award.id) == null
        assert response.redirectedUrl == '/award/list'
    }
}
