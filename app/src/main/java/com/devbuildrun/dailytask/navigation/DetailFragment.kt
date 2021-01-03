package com.devbuildrun.dailytask.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.viewpager2.widget.ViewPager2
import com.devbuildrun.dailytask.custom.CalendarAdapter
import com.devbuildrun.dailytask.custom.CalendarFragment
import com.devbuildrun.dailytask.databinding.FragmentDetailBinding
import org.joda.time.DateTime

class DetailFragment: Fragment() {

    private lateinit var calendarAdapter: CalendarAdapter
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setFragmentResultListener("resultMonth") { requestKey, bundle ->
//            val data = bundle.getString("data","")
//            binding.monthinfo.text = data
//        }
        calendarAdapter = CalendarAdapter(requireActivity())
        binding.calendarPager.adapter = calendarAdapter
        binding.calendarPager.setCurrentItem(CalendarAdapter.START_POSITION, false)
        binding.monthinfo.text = DateTime(calendarAdapter.getItemId(CalendarAdapter.START_POSITION)).toString("yyyy-MM")

        binding.calendarPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.monthinfo.text = DateTime(calendarAdapter.getItemId(position)).toString("yyyy-MM")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

