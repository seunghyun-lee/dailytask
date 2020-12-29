package com.devbuildrun.dailytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.devbuildrun.dailytask.custom.CalendarAdapter
import com.devbuildrun.dailytask.navigation.DetailFragment
import com.devbuildrun.dailytask.navigation.TodoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
//    class MainActivity : AppCompatActivity() {

    private lateinit var calendarAdapter: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        bottom_navigation.selectedItemId = R.id.action_todoitems

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_calendar -> {
                var detailFragment = DetailFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, detailFragment).commit()
                return true
            }
            R.id.action_todoitems -> {
                var todoFragment = TodoFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, todoFragment).commit()
                return true
            }
        }
        return false
    }

}
