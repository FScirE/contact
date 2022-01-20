class Contact(var firstname: String, var surname: String, var phonenumber: MutableList<String>, var mail: MutableList<String>) {
    fun print() {
        println("Firstname: $firstname\nSurname: $surname")
        var i = 1
        for (p in phonenumber) {
            println("Phone number $i: $p")
            i++
        }
        i = 1
        for (m in mail) {
            println("Mail address $i: $m")
            i++
        }
    }

    fun printlite(): String {
        return "$firstname $surname"
    }
}

class ContactHandler() {
    var contactlist: MutableList<Contact> = mutableListOf()

    fun add() {
        var line = ""
        var firstname = ""
        var surname = ""
        val phonenumber: MutableList<String> = mutableListOf()
        val mail: MutableList<String> = mutableListOf()

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
        printlite()

        print("Which contact do you want to remove? (Number only): ")
        val index: Int = readLine().toString().toInt()

        if (index < 1 || index > contactlist.size) return false
        contactlist.removeAt(index - 1)
        return true
    }

    fun edit(): Boolean {
        printlite()

        print("Which contact do you want to edit? (Number only): ")
        val index = readLine().toString().toInt()
        if (index < 1 || index > contactlist.size) return false

        println("\nWhat do you want to edit?\n[1] Firstname\n[2] Surname\n[3] Phone numbers\n[4] Mail addresses")
        val choice = readLine().toString().toInt()
        if (choice < 1 || choice > 4) return false

        if (choice == 1) {
            print("Enter new firstname: ")
            contactlist[index - 1].firstname = readLine().toString()
        }
        else if (choice == 2) {
            print("Enter new surname: ")
            contactlist[index - 1].surname = readLine().toString()
        }
        else if (choice == 3) {

        }
        else {

        }

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

    fun printlite() {
        var i = 1
        for (c in contactlist) {
            println("Contact $i: " + c.printlite())
            i++
        }
        println()
    }
}