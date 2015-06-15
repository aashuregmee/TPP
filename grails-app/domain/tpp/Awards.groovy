package tpp

class Awards {

    Date date
    String remarks

    static mapping = {
        version false
    }

    static belongsTo = [award: Awards, student: Student]

    static constraints = {

        date nullable: false
        remarks nullable: false, blank: false
    }
}
