package com.emmanuelkech.todolist.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.emmanuelkech.todolist.adapter.CallsListAdapter
import com.emmanuelkech.todolist.adapter.PlacesListAdapter
import com.emmanuelkech.todolist.adapter.TaskListAdapter
import com.emmanuelkech.todolist.databinding.FragmentTaskListBinding


class TaskListFragment : Fragment() {

    private var binding: FragmentTaskListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentTaskListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as Context

        val recyclerView = binding?.toDoRv
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = TaskListAdapter()

        val placesRecyclerView = binding?.placesRv
        placesRecyclerView?.layoutManager = LinearLayoutManager(activity)
        placesRecyclerView?.adapter = PlacesListAdapter()

        val callRecyclerView = binding?.callsRv
        callRecyclerView?.layoutManager = LinearLayoutManager(activity)
        callRecyclerView?.adapter = CallsListAdapter()
    }
}