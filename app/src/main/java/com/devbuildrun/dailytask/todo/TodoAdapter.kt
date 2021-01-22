package com.devbuildrun.dailytask.todo

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TodoAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun createFragment(position: Int): TempFragment {
        val millis = getItemId(position)
        return TempFragment.newInstance(millis)
    }

    companion object {
        const val START_POSITION = Int.MAX_VALUE / 2
    }
}