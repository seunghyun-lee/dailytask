package com.devbuildrun.dailytask.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devbuildrun.dailytask.R
import com.devbuildrun.dailytask.databinding.FragmentTempBinding
import com.devbuildrun.dailytask.databinding.FragmentTodoBinding
import com.devbuildrun.dailytask.utils.CalendarUtils.Companion.getMonthList
import org.joda.time.DateTime

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [TempFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TempFragment : Fragment() {

    private var millis: Long = 0L
    private var _binding: FragmentTempBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            millis = it.getLong(MILLIS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTempBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarTemp.initCalendar(DateTime(millis), getMonthList(DateTime(millis)))
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        private const val MILLIS = "MILLIS"
        @JvmStatic
        fun newInstance(millis: Long) =
            TempFragment().apply {
                arguments = Bundle().apply {
                    putLong(MILLIS, millis)
                }
            }
    }
}