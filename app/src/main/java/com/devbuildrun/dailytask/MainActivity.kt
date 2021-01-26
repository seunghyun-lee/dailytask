package com.devbuildrun.dailytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.devbuildrun.dailytask.databinding.ActivityMainBinding
import com.devbuildrun.dailytask.navigation.DetailFragment
import com.devbuildrun.dailytask.navigation.TodoFragment
import com.devbuildrun.dailytask.navigation.TodoItemFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
        binding.bottomNavigation.selectedItemId = R.id.action_calendar

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
            R.id.action_note -> {
                var todoItemFragment = TodoItemFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, todoItemFragment).commit()
                return true
            }
        }
        return false
    }

}
