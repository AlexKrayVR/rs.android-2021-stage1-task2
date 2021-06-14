package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {
    private var printedFormatterDate = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))

    fun toTextDay(day: String, month: String, year: String): String {
        if (month.toInt() - 1 >= 12) {
            return "Такого дня не существует"
        }
        if (month.toInt() - 1 == 1) {
            if (isLeapYear(year.toInt())) {
                if (day.toInt() > 29) {
                    return "Такого дня не существует"
                }
            } else {
                if (day.toInt() > 28) {
                    return "Такого дня не существует"
                }
            }
        }
        val currentCalendar = GregorianCalendar(year.toInt(), month.toInt() - 1, day.toInt())
        return printedFormatterDate.format(currentCalendar.time)
    }

    private fun isLeapYear(year: Int): Boolean {
        val cal = Calendar.getInstance()
        cal[Calendar.YEAR] = year
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365
    }
}

