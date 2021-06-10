package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var first = a.toLowerCase()
        var second = b.toLowerCase()
        var check = mutableListOf<Char>()
        var indexStart = 0
        for (item in second) {
            for (x in indexStart until first.length) {
                if (first[x] == item) {
                    check.add(item)
                    indexStart = x + 1
                    break
                }
            }
        }
        return if (check.toString().replace("[^A-Za-z]".toRegex(), "") == second) {
            "YES"
        } else {
            "NO"
        }
    }

}
