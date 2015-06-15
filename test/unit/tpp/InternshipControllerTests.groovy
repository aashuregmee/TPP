package tpp


import org.junit.*
import grails.test.mixin.*

@TestFor(InternshipController)
@Mock(Internship)
class InternshipControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/internship/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.internshipInstanceList.size() == 0
        assert model.internshipInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.internshipInstance != null
    }

    void testSave() {
        controller.save()

        assert model.internshipInstance != null
        assert view == '/internship/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/internship/show/1'
        assert controller.flash.message != null
        assert Internship.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/internship/list'

        populateValidParams(params)
        def internship = new Internship(params)

        assert internship.save() != null

        params.id = internship.id

        def model = controller.show()

        assert model.internshipInstance == internship
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/internship/list'

        populateValidParams(params)
        def internship = new Internship(params)

        assert internship.save() != null

        params.id = internship.id

        def model = controller.edit()

        assert model.internshipInstance == internship
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/internship/list'

        response.reset()

        populateValidParams(params)
        def internship = new Internship(params)

        assert internship.save() != null

        // test invalid parameters in update
        params.id = internship.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/internship/edit"
        assert model.internshipInstance != null

        internship.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/internship/show/$internship.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        internship.clearErrors()

        populateValidParams(params)
        params.id = internship.id
        params.version = -1
        controller.update()

        assert view == "/internship/edit"
        assert model.internshipInstance != null
        assert model.internshipInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/internship/list'

        response.reset()

        populateValidParams(params)
        def internship = new Internship(params)

        assert internship.save() != null
        assert Internship.count() == 1

        params.id = internship.id

        controller.delete()

        assert Internship.count() == 0
        assert Internship.get(internship.id) == null
        assert response.redirectedUrl == '/internship/list'
    }
}
