import kotlin.system.exitProcess

var contactHandler = ContactHandler()
var fileHandler = FileHandler()

fun main() {
    //contactHandler.contactlist.add(Contact("Eric", "Falkbring", mutableListOf("0725566809"), mutableListOf("leo.soleke@gmail.com")))
    //contactHandler.contactlist.add(Contact("Olle", "Börner", mutableListOf("0734161513"), mutableListOf("veisse.petric@gmail.com", "olle.petersson@utb.helsingborg.se")))
    fileHandler.readContactsFromFile()

    while (true) {
        println("==========================")
        println("[1] Add contact\n[2] Remove contact\n[3] Edit contact\n[4] Print contacts (compact)\n[5] Print contacts (full)\n[6] Sort list by name\n[7] Exit and save")
        println("==========================")
        when (readLine()!!.toInt()) {
            1 -> {
                contactHandler.add()
                println("\nContact added!\n")
            }
            2 -> {
                val successful = contactHandler.remove()
                if (successful) println("\nContact removed.\n")
                else println("\nCouldn't remove contact.\n")
            }
            3 -> {
                val successful = contactHandler.edit()
                if (successful) println("\nContact edited!\n")
                else println("\nCouldn't edit contact.\n")
            }
            4 -> {
                contactHandler.printlite()
            }
            5 -> {
                contactHandler.print()
            }
            6 -> {
                contactHandler.contactlist.sortWith(compareBy(String.CASE_INSENSITIVE_ORDER) {it.firstname})
                println("\nList sorted!\n")
            }
            7 -> {
                println("Exiting...")
                fileHandler.writeContactsToFile()
                exitProcess(0)
            }
        }
    }
}