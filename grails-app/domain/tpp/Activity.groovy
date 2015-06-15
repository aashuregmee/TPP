package tpp

class Activity {

    String name
    String description
    String venue
    Date date

    static mapping = {
        version false
    }

    static constraints = {

        name nullable: false, blank: false
        description nullable: false, blank: false
        venue nullable: false, blank: false
        date nullable: false
    }
}
