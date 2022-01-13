class Contact(var firstname: String, var surname: String, var phonenumber: MutableList<String>, var mail: MutableList<String>) {
    fun print() {
        println("Firstname: $firstname\nSurname: $surname")
        var i = 1
        for (p in phonenumber) {
            println("Phonenumber $i: $p")
            i++
        }
        i = 1
        for (m in mail) {
            println("Mail $i: $m")
            i++
        }
    }
}

class ContactHandler() {
    var contactlist: MutableList<Contact> = mutableListOf()

    fun add() {
        var line = ""
        var firstname = ""
        var surname = ""
        var phonenumber: MutableList<String> = mutableListOf()
        var mail: MutableList<String> = mutableListOf()

        print("Enter firstname: ")
        line = readLine().toString()
        firstname = line

        print("Enter surname: ")
        line = readLine().toString()
        surname = line

        print("Enter phone number: ")
        phonenumber.add(readLine().toString())

        while (true) {
            print("Enter another phone number (empty to continue): ")
            line = readLine().toString()
            if (line == "") break
            phonenumber.add(line)
        }

        print("Enter mail: ")
        mail.add(readLine().toString())
        while (true) {
            print("Enter another mail (empty to continue): ")
            line = readLine().toString()
            if (line == "") break
            mail.add(line)
        }

        contactlist.add(Contact(firstname, surname, phonenumber, mail))
    }

    fun remove(): Boolean {
        var index: Int = -1

        print()

        print("Which contact do you want to remove? (Number only): ")
        index = readLine().toString().toInt()

        if (index < 1 || index > contactlist.size) return false
        contactlist.removeAt(index - 1)
        return true
    }

    fun print() {
        var i = 1
        for (c in contactlist) {
            println("Contact $i ----------------------")
            c.print()
            println("---------------------------------\n")
            i++
        }
    }
}