package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

// 25
operator fun MyDate.compareTo(other: MyDate): Int =
        if (this.year != other.year) this.year - other.year
        else if (this.month != other.month) this.month - other.month
        else if (this.dayOfMonth != other.dayOfMonth) this.dayOfMonth - other.dayOfMonth
        else 0

// 26
operator fun DateRange.contains(d: MyDate): Boolean = this.start <= d && d <= this.endInclusive

// 27
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

// 28
operator fun DateRange.iterator() = object : Iterator<MyDate> {
    var currentItem = this@iterator.start

    override fun hasNext(): Boolean = currentItem <= this@iterator.endInclusive

    override fun next(): MyDate {
        val temp = currentItem
        currentItem = currentItem.nextDay()
        return temp
    }
}

// 29
operator fun TimeInterval.times(int: Int): Pair<TimeInterval, Int> = Pair(this, int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)

operator fun MyDate.plus(pair: Pair<TimeInterval, Int>) = this.addTimeIntervals(pair.first, pair.second)