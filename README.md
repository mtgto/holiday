holiday
========
Scala library to judge the day is holiday in Japan.

# How to use
## 1. Add holiday to your scala project.
```
resolvers += "confluence4s repos" at "http://mtgto.github.com/holiday/maven/"

libraryDependencies += "net.mtgto" %% "holiday" % "0.1.0"
```

## 2. Use it
```scala
import net.mtgto.holiday._
if (Holiday.isHoliday(2013, 1, 14)) {
    println("2013-1-14 is holiday!")
}

import net.mtgto.holiday.Holiday._
if (new java.util.Date(113, 0, 14).isHoliday) {
    println("2013-1-14 is holiday!")
}
```

## 3. License
`holiday` is licensed under the zlib license.
