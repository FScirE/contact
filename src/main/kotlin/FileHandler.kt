import java.io.File
import java.io.InputStream

class FileHandler {
    fun readContactsFromFile() {
        var inputStream: InputStream = InputStream.nullInputStream()
        val file = File("contacts.txt")

        //skapar fil om den inte finns
        if (file.exists()) inputStream = file.inputStream()
        else file.createNewFile()

        //skapar lista av strings för varje rad i filen
        val lineList = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { lineList.add(it) }

        var lineCounter = 0 //räknar vilken rad till kontakten som skrivs
        //temporära värden
        var tempFirstname = ""
        var tempSurname = ""
        var tempPhonenumber: MutableList<String> = mutableListOf()
        var tempMail: MutableList<String> = mutableListOf()

        for (s in lineList) {
            if (s == "%Contact%") {contactHandler.contactlist.add(Contact(tempFirstname, tempSurname, tempPhonenumber, tempMail)) //lägger till kontakt i listan när slutraden är nådd
                //återställer temporära värden till nästa kontakt
                tempFirstname = ""
                tempSurname = ""
                tempPhonenumber = mutableListOf()
                tempMail = mutableListOf()
                lineCounter = 0

                continue //skippar when-satsen
            }
            else lineCounter++ //går vidare till nästa rad

            //lägger till värden från rätt rad men hjälp av linecounter
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
        //gör textfilen tom för att få plats med ny info
        file.writeText("")

        for (c in contactHandler.contactlist) {
            file.appendText(c.firstname + "%" + c.surname + "\n") //förnamn och efternamn separerat med %
            for (p in c.phonenumber) {
                file.appendText("$p%") //alla telefonnummer separerade med %
            }
            file.appendText("\n")
            for (m in c.mail) {
                file.appendText("$m%") //alla mail separerade med %
            }
            file.appendText("\n%Contact%\n") //en rad för att separera kontakter
        }
    }
}