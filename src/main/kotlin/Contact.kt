class Contact(var firstname: String, var surname: String, var phonenumber: MutableList<String>, var mail: MutableList<String>) {
    fun print() {
        //fullständig information
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
        //kompakt information
        return "$firstname $surname"
    }
}

class ContactHandler {
    val contactlist: MutableList<Contact> = mutableListOf()

    fun add() {
        //skapa temporära listor för telefonnummer och mail
        val phonenumber: MutableList<String> = mutableListOf()
        val mail: MutableList<String> = mutableListOf()

        //spara ett temporärt förnamn
        print("Enter firstname: ")
        var line = readLine().toString()
        val firstname = line

        //spara ett temporärt efternamn
        print("Enter surname: ")
        line = readLine().toString()
        val surname = line

        //lägg till ett telefonnummer i listan
        print("Enter phone number: ")
        phonenumber.add(readLine().toString())
        while (true) {
            //lägger till fler telefonnummer tills man lämnar fältet tomt
            print("Enter another phone number (empty to continue): ")
            line = readLine().toString()
            if (line == "") break //går ur loopen
            phonenumber.add(line)
        }

        //samma som telefonnummer fast för mail
        print("Enter mail: ")
        mail.add(readLine().toString())
        while (true) {
            print("Enter another mail (empty to continue): ")
            line = readLine().toString()
            if (line == "") break
            mail.add(line)
        }

        //lägger till en kontakt i kontaktlistan med de temporära värdena
        contactlist.add(Contact(firstname, surname, phonenumber, mail))
    }

    fun remove(): Boolean {
        printlite()

        print("Which contact do you want to remove? (Number only): ")
        val index: Int = readLine().toString().toInt()

        if (index < 1 || index > contactlist.size) return false //returnera false när det inte går att redigera (för litet eller för stort index)
        contactlist.removeAt(index - 1)
        return true //returnerar true när det gick att ta bort kontakten
    }

    fun edit(): Boolean {
        //visar en kompakt lista av alla kontakter så du kan se vilken du ska redigera
        printlite()

        print("Which contact do you want to edit? (Number only): ")
        val index = readLine()!!.toInt()
        if (index < 1 || index > contactlist.size) return false //returnerar falskt om det inte går att redigera (för litet eller för stort värde)
        val contact = contactlist[index - 1]

        //visa fullständig information om kontakten
        println()
        contact.print()

        println("\nWhat do you want to edit?\n[1] Firstname\n[2] Surname\n[3] Phone numbers\n[4] Mail addresses")
        val choice = readLine()!!.toInt()
        if (choice < 1 || choice > 4) return false //returnerar falskt om det inte går att redigera (för litet eller för stort värde)

        //hantera val
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
                when (readLine()!!.toInt()) {
                    1 -> {
                        print("Enter new phone number: ")
                        contact.phonenumber.add(readLine().toString())
                    }
                    2 -> {
                        print("Which phone number do you want to remove? (Number only): ")
                        contact.phonenumber.removeAt(readLine()!!.toInt() - 1)
                    }
                    else -> return false
                }
            }
            else -> {
                //samma som telefonnummer fast för mail
                println("[1] Add mail address\n[2] Remove mail address")
                when (readLine()!!.toInt()) {
                    1 -> {
                        print("Enter new mail address: ")
                        contact.mail.add(readLine().toString())
                    }
                    2 -> {
                        print("Which mail address do you want to remove? (Number only): ")
                        contact.mail.removeAt(readLine()!!.toInt() - 1)
                    }
                    else -> return false
                }
            }
        }

        return true //returnerar true när redigeringen gick utan problem
    }

    fun print() {
        //visar all information om kontakterna
        var i = 1
        for (c in contactlist) {
            print("Contact $i ")
            //så att det ska vara lika lång rad oavsett kontakt-nummer
            for (b in 0 ..  10 - i/10) { print("-") }
            print("------------\n")
            c.print()
            println("---------------------------------\n")
            i++
        }
    }

    fun printlite() {
        //visar endast förnamn och efternamn till kontakterna, lättare att se alla kontakter
        var i = 1
        for (c in contactlist) {
            println("Contact $i: " + c.printlite())
            i++
        }
        println()
    }
}