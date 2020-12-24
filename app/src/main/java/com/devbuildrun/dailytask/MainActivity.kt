package com.devbuildrun.dailytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.devbuildrun.dailytask.navigation.calendar.CalendarAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

//class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    class MainActivity : AppCompatActivity() {

    private lateinit var calendarAdapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarAdapter = CalendarAdapter(this)
        calendar.adapter = calendarAdapter
        calendar.setCurrentItem(CalendarAdapter.START_POSITION, false)
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//
//    }
//
//    fun setToolbarDefault() {
//
//    }
}