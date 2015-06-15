package tpp

class Participation {

    Integer semesterNo
    String remarks

    static mapping = {
        version false
    }

    static belongsTo = [activity: Activity, student: Student]

    static constraints = {

        semesterNo min: 1, max: 8
        remarks nullable: false, blank: false
    }
}
