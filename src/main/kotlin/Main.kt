import kotlin.system.exitProcess

var contactHandler = ContactHandler()
var fileHandler = FileHandler()

fun main(args: Array<String>) {
    //contactHandler.contactlist.add(Contact("Eric", "Falkbring", mutableListOf("0725566809"), mutableListOf("leo.soleke@gmail.com")))
    //contactHandler.contactlist.add(Contact("Olle", "Börner", mutableListOf("0734161513"), mutableListOf("veisse.petric@gmail.com", "olle.petersson@utb.helsingborg.se")))
    fileHandler.readContactsFromFile()

    while (true) {
        var choice = -1
        println("==========================")
        println("[1] Add contact\n[2] Remove contact\n[3] Edit contact\n[4] Print contacts (compact)\n[5] Print contacts (full)\n[6] Exit and save")
        println("==========================")
        choice = readLine().toString().toInt()

        if (choice == 1) {
            contactHandler.add()
            println("\nContact added!\n")
        }
        else if (choice == 2) {
            val successful = contactHandler.remove()
            if (successful) println("\nContact removed.\n")
            else println("\nCouldn't remove contact.\n")
        }
        else if (choice == 3) {
            val successful = contactHandler.edit()
            if (successful) println("\nContact edited!\n")
            else println("\nCouldn't edit contact.\n")
        }
        else if (choice == 4) {
            contactHandler.printlite()
        }
        else if (choice == 5) {
            contactHandler.print()
        }
        else if (choice == 6) {
            fileHandler.writeContactsToFile()
            exitProcess(0)
        }
    }
}