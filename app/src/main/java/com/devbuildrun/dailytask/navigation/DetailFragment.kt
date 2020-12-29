package com.devbuildrun.dailytask.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.devbuildrun.dailytask.R
import com.devbuildrun.dailytask.custom.CalendarAdapter
import com.devbuildrun.dailytask.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlin.math.atan2

class DetailFragment: Fragment() {

    private lateinit var calendarAdapter: CalendarAdapter
//    private var millis: Long = 0L

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_detail, container, false)
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.testtext.text = "test!!!!"
        calendarAdapter = CalendarAdapter(requireActivity())
        binding.calendarPager.adapter = calendarAdapter
        binding.calendarPager.setCurrentItem(CalendarAdapter.START_POSITION, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
