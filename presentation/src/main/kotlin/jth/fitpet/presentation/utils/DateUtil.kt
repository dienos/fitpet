package jth.fitpet.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        private const val WEATHER_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
        const val NEW_WEATHER_DATE_FORMAT = "EE dd MMM hh:mm a"
        const val HOUR_MIN_FORMAT = "hh:mm a"
        private const val YEAR_DAY_FORMAT = "yyyyMMdd"

        fun convertDateStringFormat(
            dateString: String?,
            changeFormatString: String,
            locale: Locale
        ): String {
            dateString?.let {
                val input = SimpleDateFormat(WEATHER_DATE_FORMAT, locale)
                val output = SimpleDateFormat(changeFormatString, locale)
                val newDt: Date? = input.parse(it)

                newDt?.let { date ->
                    return output.format(date)
                } ?: return ""
            }

            return ""
        }

        fun currentDate(formatString: String): String {
            val nowDate = System.currentTimeMillis()
            val date = Date(nowDate)
            val dataFormat = SimpleDateFormat(formatString, Locale.getDefault())
            return dataFormat.format(date)
        }

        fun differenceDays(dateString: String?): Int {
            dateString?.let {
                val nowDate = currentDate(YEAR_DAY_FORMAT)
                val date = convertDateStringFormat(dateString, YEAR_DAY_FORMAT, Locale.getDefault())

                if(nowDate.isEmpty().not() && date.isEmpty().not()) {
                    return date.toInt() - nowDate.toInt()
                }
            }

            return 0
        }
    }
}