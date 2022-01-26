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

class ContactHandler {
    var contactlist: MutableList<Contact> = mutableListOf()

    fun add() {
        val phonenumber: MutableList<String> = mutableListOf()
        val mail: MutableList<String> = mutableListOf()

        print("Enter firstname: ")
        var line = readLine().toString()
        val firstname = line

        print("Enter surname: ")
        line = readLine().toString()
        val surname = line

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
        val contact = contactlist[index - 1]

        println()
        contact.print()

        println("\nWhat do you want to edit?\n[1] Firstname\n[2] Surname\n[3] Phone numbers\n[4] Mail addresses")
        val choice = readLine().toString().toInt()
        if (choice < 1 || choice > 4) return false

        when (choice) {
            1 -> {
                print("Enter new firstname: ")
                contact.firstname = readLine().toString()
            }
            2 -> {
                print("Enter new surname: ")
                contact.surname = readLine().toString()
            }
            3 -> {
                println("[1] Add phone number\n[2] Remove phone number")
                when (readLine().toString().toInt()) {
                    1 -> {
                        print("Enter new phone number: ")
                        contact.phonenumber.add(readLine().toString())
                    }
                    2 -> {
                        print("Which phone number do you want to remove? (Number only): ")
                        contact.phonenumber.removeAt(readLine().toString().toInt() - 1)
                    }
                    else -> return false
                }
            }
            else -> {
                println("[1] Add mail address\n[2] Remove mail address")
                when (readLine().toString().toInt()) {
                    1 -> {
                        print("Enter new mail address: ")
                        contact.mail.add(readLine().toString())
                    }
                    2 -> {
                        print("Which mail address do you want to remove? (Number only): ")
                        contact.mail.removeAt(readLine().toString().toInt() - 1)
                    }
                    else -> return false
                }
            }
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