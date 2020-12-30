package com.devbuildrun.dailytask.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devbuildrun.dailytask.custom.CalendarAdapter
import com.devbuildrun.dailytask.custom.CalendarFragment
import com.devbuildrun.dailytask.databinding.FragmentDetailBinding

class DetailFragment: Fragment() {
//    class DetailFragment: Fragment(), CalendarFragment.OnFragmentInteractionListener {

    private lateinit var calendarAdapter: CalendarAdapter
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

//    override fun onFragmentInteraction(msg: String) {
//        binding.monthinfo.text = msg
//    }
//
//    private val fragment: CalendarFragment by lazy { CalendarFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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

        calendarAdapter = CalendarAdapter(requireActivity())
        binding.calendarPager.adapter = calendarAdapter
        binding.calendarPager.setCurrentItem(CalendarAdapter.START_POSITION, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
