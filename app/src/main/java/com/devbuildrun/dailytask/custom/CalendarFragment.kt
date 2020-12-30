package com.devbuildrun.dailytask.custom

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.devbuildrun.dailytask.R
import com.devbuildrun.dailytask.databinding.FragmentCalendarBinding
import com.devbuildrun.dailytask.databinding.FragmentDetailBinding
import com.devbuildrun.dailytask.navigation.DetailFragment
import com.devbuildrun.dailytask.utils.CalendarUtils.Companion.getMonthList
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import org.joda.time.DateTime
import java.lang.RuntimeException

class CalendarFragment: Fragment() {

//    private var listener: OnFragmentInteractionListener? = null
//
//    interface OnFragmentInteractionListener {
//        fun onFragmentInteraction(msg: String)
//    }

    private var millis: Long = 0L
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            millis = it.getLong(MILLIS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
//        view.millis.text = DateTime(millis).toString("yyyy-MM")
//        listener?.onFragmentInteraction(DateTime(millis).toString("yyyy-MM"))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarView.initCalendar(DateTime(millis), getMonthList(DateTime(millis)))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
//        listener = null
    }

    companion object {
        private const val MILLIS = "MILLIS"

        fun newInstance(millis: Long) = CalendarFragment().apply {
            arguments = Bundle().apply {
                putLong(MILLIS, millis)
            }
        }
    }
}