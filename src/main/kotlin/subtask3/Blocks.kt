package subtask3

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        if (blockB.simpleName.equals("String")) {
            var summa = ""
            for (item in blockA) {
                if (item is String) {
                    summa += item
                }
            }
            return summa
        }

        if (blockB.simpleName.equals("Int")) {
            var summa = 0
            for (item in blockA) {
                if (item is Int) {
                    summa += item
                }
            }
            return summa
        }

        val printedFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        var currentCalendar: GregorianCalendar = GregorianCalendar(
            1,
            1,
            1
        )
        var temp: GregorianCalendar = currentCalendar

        if (blockB.simpleName.equals("LocalDate")) {
            for (index in blockA.size - 1 downTo 0) {
                if (blockA[index] is LocalDate) {
                    currentCalendar = GregorianCalendar(
                        (blockA[index] as LocalDate).year,
                        (blockA[index] as LocalDate).monthValue - 1,
                        (blockA[index] as LocalDate).dayOfMonth
                    )
                    if (currentCalendar.after(temp)) {
                        temp = currentCalendar
                    }
                }
            }
            return printedFormatter.format(temp.time)
        }
        return ""
    }

}
