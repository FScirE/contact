import java.io.File
import java.io.InputStream

class FileHandler {
    fun readContactsFromFile() {
        var inputStream: InputStream = InputStream.nullInputStream()
        val file = File("contacts.txt")

        if (file.exists()) inputStream = file.inputStream()
        else file.createNewFile()

        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { lineList.add(it) }

        var lineCounter = 0
        var tempFirstname = ""
        var tempSurname = ""
        var tempPhonenumber: MutableList<String> = mutableListOf()
        var tempMail: MutableList<String> = mutableListOf()

        for (s in lineList) {
            if (s == "%Contact%") {contactHandler.contactlist.add(Contact(tempFirstname, tempSurname, tempPhonenumber, tempMail))
                tempFirstname = ""
                tempSurname = ""
                tempPhonenumber = mutableListOf()
                tempMail = mutableListOf()
                lineCounter = 0

                continue
            }
            else lineCounter++

            when (lineCounter) {
                //Förnamn och efternamn
                1 -> {
                    val tempLine: List<String> = s.split('%')
                    tempFirstname = tempLine[0]
                    tempSurname = tempLine[1]
                }
                //Telefonnummer
                2 -> {
                    val tempLine: List<String> = s.split('%')
                    for (l in tempLine) {
                        if (l != "") {
                            tempPhonenumber.add(l)
                        }
                    }
                }
                //E-postadress
                else -> {
                    val tempLine: List<String> = s.split('%')
                    for (l in tempLine) {
                        if (l != "") {
                            tempMail.add(l)
                        }
                    }
                }
            }
        }
    }

    fun writeContactsToFile() {
        val file = File("contacts.txt")
        file.writeText("")

        for (c in contactHandler.contactlist) {
            file.appendText(c.firstname + "%" + c.surname + "\n")
            for (p in c.phonenumber) {
                file.appendText("$p%")
            }
            file.appendText("\n")
            for (m in c.mail) {
                file.appendText("$m%")
            }
            file.appendText("\n%Contact%\n")
        }
    }
}