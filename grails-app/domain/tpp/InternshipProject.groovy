package tpp

class InternshipProject {

    String projectName

    static mapping = {
        version false
    }

    static constraints = {

        projectName nullable: false, blank: false
    }
}
