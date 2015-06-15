package tpp

class Subject {

    String name
    Integer semesterNo

    static mapping = {
        version false
    }

    static constraints = {

        name nullable: false, blank: false
        semesterNo min: 1, max: 8
    }
}
