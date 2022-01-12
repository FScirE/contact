class Contact(var firstname: String, var surname: String, var phonenumber: List<String>, var mail: List<String>)

abstract class ContactHandler {
    abstract var contactlist: List<Contact>
    fun add() {

    }
}