package tpp

class Academics {

    Integer semesterNo
    String adminComment

    static mapping = {
        version false
    }

    static belongsTo = [student: Student]

    static constraints = {

        semesterNo min: 1, max: 8
        adminComment nullable: false, blank: false
        student nullable: false
    }
}
