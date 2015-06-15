package tpp

class Internship {

    Date startDate
    Date endDate
    String mentorName

    static mapping = {
        version false
    }

    static belongsTo = [internshipProject: InternshipProject, student: Student]

    static constraints = {

        startDate nullable: false
        endDate nullable: false
        mentorName nullable: false, blank: false
    }
}
