package net.mtgto.holiday

import org.specs2.mutable._

class HolidaySpec extends Specification {
  "Holiday" should {
    "be true when specified date is saturday" in {
      Holiday.isHoliday(2013, 1, 12) must beTrue
      Holiday.isHoliday(2013, 1, 19) must beTrue
      Holiday.isHoliday(2012, 9, 15) must beTrue
    }

    "be false when specified date is monday" in {
      Holiday.isHoliday(2013, 1, 21) must beFalse
      Holiday.isHoliday(2013, 1, 28) must beFalse
      Holiday.isHoliday(2012, 7, 23) must beFalse
    }

    "be true when specified date is a national holiday" in {
      Holiday.isHoliday(2013, 1, 1) must beTrue
      Holiday.isHoliday(2013, 1, 14) must beTrue
      Holiday.isHoliday(2013, 2, 11) must beTrue
      Holiday.isHoliday(2013, 3, 20) must beTrue
      Holiday.isHoliday(2013, 4, 29) must beTrue
      Holiday.isHoliday(2013, 5, 3) must beTrue
      Holiday.isHoliday(2013, 5, 4) must beTrue
      Holiday.isHoliday(2013, 5, 5) must beTrue
      Holiday.isHoliday(2013, 7, 15) must beTrue
      Holiday.isHoliday(2013, 9, 16) must beTrue
      Holiday.isHoliday(2013, 9, 23) must beTrue
      Holiday.isHoliday(2013, 10, 14) must beTrue
      Holiday.isHoliday(2013, 11, 3) must beTrue
      Holiday.isHoliday(2013, 11, 23) must beTrue
      Holiday.isHoliday(2013, 12, 23) must beTrue
    }

    "be true when specified date is monday and yesterday is national holiday" in {
      Holiday.isHoliday(2013, 5, 6) must beTrue
      Holiday.isHoliday(2013, 11, 4) must beTrue
    }
  }
}
