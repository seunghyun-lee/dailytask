package com.devbuildrun.dailytask.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebSettings.ZoomDensity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.devbuildrun.dailytask.R
import com.devbuildrun.dailytask.custom.CalendarAdapter
import com.devbuildrun.dailytask.custom.CalendarFragment
import com.devbuildrun.dailytask.databinding.FragmentCalendarBinding
import com.devbuildrun.dailytask.databinding.FragmentDetailBinding
import com.devbuildrun.dailytask.databinding.FragmentTodoBinding
import com.devbuildrun.dailytask.utils.CalendarUtils
import org.joda.time.DateTime

class TodoFragment: Fragment() {

    private lateinit var calendarAdapter: CalendarAdapter
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setFragmentResultListener("resultMonth") { requestKey, bundle ->
//            val data = bundle.getString("data","")
//            binding.monthinfo.text = data
//        }
        calendarAdapter = CalendarAdapter(requireActivity())
        binding.calendarTemp.adapter = calendarAdapter
//        binding.calendarTemp.setPageTransformer(ZoomDensity)
        binding.calendarTemp.setCurrentItem(CalendarAdapter.START_POSITION, false)
//        binding.monthinfo.text = DateTime(calendarAdapter.getItemId(CalendarAdapter.START_POSITION)).toString("yyyy-MM")

//        binding.calendarPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                binding.monthinfo.text = DateTime(calendarAdapter.getItemId(position)).toString("yyyy-MM")
//            }
//        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}