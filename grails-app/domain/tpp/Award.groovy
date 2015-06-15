package tpp

class Award {

    String title
    String description

    static mapping = {
        version false
    }

    static constraints = {

        title nullable: false, blank: false
        description nullable: false, blank: false
    }

    static hasMany = [awards: Awards]
}
