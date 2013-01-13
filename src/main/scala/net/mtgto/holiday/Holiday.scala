package net.mtgto.holiday

import java.util.{Date => JDate, Calendar, GregorianCalendar}

/**
 * A collections of function check whether the specified date is holiday in Japanese.
 *
 * these functions have some rules:
 * 1. Sunday is holiday.
 * 2. Saturday is also holiday.
 * 3. National holiday is holiday.
 * 4. If yesterday is holiday and today is Monday, then today is holiday.
 */
object Holiday {
  def isHoliday(year: Int, month: Int, day: Int): Boolean = {
    val calendar = new GregorianCalendar(year, month-1, day)
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH)
    if ((dayOfWeek == Calendar.SUNDAY) || (dayOfWeek == Calendar.SATURDAY) || isNationalHoliday(year, month, day))
      true
    else {
      val yesterdayCalendar = new GregorianCalendar(year, month-1, day-1)
      val yesterdayYear = yesterdayCalendar.get(Calendar.YEAR)
      val yesterdayMonth = yesterdayCalendar.get(Calendar.MONTH) + 1
      val yesterdayDayOfMonth = yesterdayCalendar.get(Calendar.DAY_OF_MONTH)
      weekOfMonth == Calendar.MONDAY && isNationalHoliday(yesterdayYear, yesterdayMonth, yesterdayDayOfMonth)
    }
  }

  protected def isNationalHoliday(year: Int, month: Int, day: Int): Boolean = {
    assert(year == 2012 || year == 2013)
    val calendar = new GregorianCalendar(year, month-1, day)
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val weekOfMonth = (day - 1) / 7 + 1
    (month == 1 && day == 1) || // New Year's Day
    (month == 1 && dayOfWeek == Calendar.MONDAY && weekOfMonth == 2) || // Coming-of-Age Day
    (month == 2 && day == 11) || // National Foundation Day
    ((year == 2012 && month == 3 && day == 20) || (year == 2013 && month == 3 && day == 20)) || // Vernal Equinox Day
    (month == 4 && day == 29) || // Showa Day
    (month == 5 && day == 3) || // Constitution Day
    (month == 5 && day == 4) || // Greenery Day
    (month == 5 && day == 5) || // Children's Day
    (month == 7 && dayOfWeek == Calendar.MONDAY && weekOfMonth == 3) || // Marine Day
    (month == 9 && dayOfWeek == Calendar.MONDAY && weekOfMonth == 3) || // Respect-for-the-Aged Day
    ((year == 2012 && month == 9 && day == 22) || (year == 2013 && month == 9 && day == 23)) || // Autumnal Equinox Day
    (month == 10 && dayOfWeek == Calendar.MONDAY && weekOfMonth == 2) || // Health and Sports Day
    (month == 11 && day == 3) || // Culture Day
    (month == 11 && day == 23) || // Labor Thanksgiving Day
    (month == 12 && day == 23) // The Emperor's Birthday
  }

  def isHoliday(date: JDate): Boolean = {
    val calendar = new GregorianCalendar
    calendar.setTime(date)
    isHoliday(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH))
  }

  import scala.language.implicitConversions

  class DateConverter(date: => JDate) {
    def isHoliday: Boolean = Holiday.isHoliday(date)
  }

  implicit def convertDateToDateConverter(date: JDate): DateConverter = new DateConverter(date)
}
