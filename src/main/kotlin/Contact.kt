class Contact(var firstname: String, var surname: String, var phonenumber: MutableList<String>, var mail: MutableList<String>) {
    fun print() {
        println("Firstname: $firstname \n Surname: $surname")
        var i = 1
        for (p in phonenumber) {
            println("Phonenumber $i: $p")
            i++
        }
        i = 1
        for (m in mail) {
            println("Mail: $i: $m")
            i++
        }
    }
}

class ContactHandler {
    private var contactlist: MutableList<Contact> = mutableListOf()

    fun add() {
        var firstname: String = ""
        var surname: String = ""
        var phonenumber: MutableList<String> = mutableListOf()
        var mail: MutableList<String> = mutableListOf()

        firstname = "Eric"
        surname = "Falkbring"
        phonenumber.add("0725566809")
        mail.add("leo.soleke@gmail.com")

        contactlist.add(Contact(firstname, surname, phonenumber, mail))
    }

    fun print() {
        var i = 1
        for (c in contactlist) {
            println("Contact $i ------------------")
            c.print()
            println("----------------------------- \n")
        }
    }
}