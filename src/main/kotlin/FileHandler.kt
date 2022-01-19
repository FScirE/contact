import java.io.File
import java.io.InputStream

class FileHandler() {
    fun readContactsFromFile(): MutableList<Contact> {
        val tempList: MutableList<Contact> = mutableListOf()
        val inputStream: InputStream = File("contacts.txt").inputStream()
        val lineList = mutableListOf<String>()

        for (s in lineList) {
            //dela upp lista i flera listor
        }

        return tempList
    }
    fun writeContactsToFile() {
        val file = File("contacts.txt")
        file.createNewFile()
        file.writeText("")

        for (c in contactHandler.contactlist) {
            file.appendText("%Contact%\n")
            file.appendText(c.firstname + "%" + c.surname + "\n")
            for (p in c.phonenumber) {
                file.appendText("$p%")
            }
            file.appendText("\n")
            for (m in c.mail) {
                file.appendText("$m%")
            }
            file.appendText("\n")
        }
    }
}