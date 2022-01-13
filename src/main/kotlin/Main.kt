var contactHandler = ContactHandler()

fun main(args: Array<String>) {
    contactHandler.contactlist.add(Contact("Eric", "Falkbring", mutableListOf<String>("0725566809"), mutableListOf("leo.soleke@gmail.com")))
    contactHandler.contactlist.add(Contact("Olle", "Börner", mutableListOf<String>("0734161513"), mutableListOf("veisse.petric@gmail.com", "olle.petersson@utb.helsingborg.se")))

    while (true) {
        var choice = -1
        println("==========================")
        println("[1] Add contact\n[2] Remove contact\n[3] Print contacts")
        println("==========================")
        choice = readLine().toString().toInt()

        if (choice == 1) {
            contactHandler.add()
            println("\nContact added!\n")
        }
        else if (choice == 2) {
            var successful = contactHandler.remove()
            if (successful) println("\nContact removed.\n")
            else println("\nCouldn't remove contact.\n")
        }
        else if (choice == 3) {
            contactHandler.print()
        }
    }
}