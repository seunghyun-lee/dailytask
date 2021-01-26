package com.devbuildrun.dailytask.navigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.devbuildrun.dailytask.R
import com.devbuildrun.dailytask.data.AppDatabase
import com.devbuildrun.dailytask.databinding.FragmentTodoitemBinding

class TodoItemFragment() : Fragment() {

    private var _binding: FragmentTodoitemBinding? = null
    private val binding get() = _binding!!
    private var mContext: Context? = null

    private var todoItemRecyclerViewAdapter: TodoItemRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoitemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val db = Room.databaseBuilder(mContext!!, AppDatabase::class.java,"todoitem-db").build()
//        binding.testTextview.text = db.todoitamDao().getAll().toString()
        todoItemRecyclerViewAdapter = TodoItemRecyclerViewAdapter()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mContext = context
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    inner class TodoItemRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        init {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)

        override fun getItemCount(): Int {
//            TODO("Not yet implemented")
            return 0
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//            TODO("Not yet implemented")
        }
    }
}