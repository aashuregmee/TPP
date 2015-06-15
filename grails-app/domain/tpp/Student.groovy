package tpp

class Student {

    String rollNo
    String firstName
    String middleName
    String lastName
    Integer currentSemesterNo
    String collegeApplicationFormPath
    String batch

    static mapping = {
        version false
        id generator: 'assigned', name: 'rollNo'
    }

    static hasMany = [academics: Academics, participations: Participation, awards: Awards]

    static constraints = {

        academics nullable: true
        participations nullable: true
        awards nullable: true
        currentSemesterNo min: 1, max: 8
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        middleName nullable: true, blank: false
        collegeApplicationFormPath nullable: false, blank: false
    }
}
