package com.devbuildrun.dailytask.custom

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.joda.time.DateTime

class CalendarAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    // 달의 첫번째 Day timeInMillis
    private var start: Long = DateTime().withDayOfMonth(1).withTimeAtStartOfDay().millis

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun createFragment(position: Int): CalendarFragment {
        val millis = getItemId(position)
        return CalendarFragment.newInstance(millis)
    }

    override fun getItemId(position: Int): Long {
        return DateTime(start).plusMonths(position - START_POSITION).millis
    }

    override fun containsItem(itemId: Long): Boolean {
        val date = DateTime(itemId)
        return date.dayOfMonth == 1 && date.millisOfDay == 0
    }
    companion object {
        const val START_POSITION = Int.MAX_VALUE / 2
    }
}