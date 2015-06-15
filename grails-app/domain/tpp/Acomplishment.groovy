package tpp

class Acomplishment {

    String title
    String description
    Integer semesterNo
    Date date

    static mapping = {
        version false
    }

    static constraints = {

        semesterNo min: 1, max: 8
        title nullable: false, blank: false
        description nullable: false, blank: false
        date nullable: false
    }
}
