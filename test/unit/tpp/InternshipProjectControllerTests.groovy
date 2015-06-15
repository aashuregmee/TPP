package tpp


import org.junit.*
import grails.test.mixin.*

@TestFor(InternshipProjectController)
@Mock(InternshipProject)
class InternshipProjectControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/internshipProject/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.internshipProjectInstanceList.size() == 0
        assert model.internshipProjectInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.internshipProjectInstance != null
    }

    void testSave() {
        controller.save()

        assert model.internshipProjectInstance != null
        assert view == '/internshipProject/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/internshipProject/show/1'
        assert controller.flash.message != null
        assert InternshipProject.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/internshipProject/list'

        populateValidParams(params)
        def internshipProject = new InternshipProject(params)

        assert internshipProject.save() != null

        params.id = internshipProject.id

        def model = controller.show()

        assert model.internshipProjectInstance == internshipProject
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/internshipProject/list'

        populateValidParams(params)
        def internshipProject = new InternshipProject(params)

        assert internshipProject.save() != null

        params.id = internshipProject.id

        def model = controller.edit()

        assert model.internshipProjectInstance == internshipProject
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/internshipProject/list'

        response.reset()

        populateValidParams(params)
        def internshipProject = new InternshipProject(params)

        assert internshipProject.save() != null

        // test invalid parameters in update
        params.id = internshipProject.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/internshipProject/edit"
        assert model.internshipProjectInstance != null

        internshipProject.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/internshipProject/show/$internshipProject.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        internshipProject.clearErrors()

        populateValidParams(params)
        params.id = internshipProject.id
        params.version = -1
        controller.update()

        assert view == "/internshipProject/edit"
        assert model.internshipProjectInstance != null
        assert model.internshipProjectInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/internshipProject/list'

        response.reset()

        populateValidParams(params)
        def internshipProject = new InternshipProject(params)

        assert internshipProject.save() != null
        assert InternshipProject.count() == 1

        params.id = internshipProject.id

        controller.delete()

        assert InternshipProject.count() == 0
        assert InternshipProject.get(internshipProject.id) == null
        assert response.redirectedUrl == '/internshipProject/list'
    }
}
