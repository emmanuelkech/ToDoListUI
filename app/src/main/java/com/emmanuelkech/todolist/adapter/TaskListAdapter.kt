package com.emmanuelkech.todolist.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.emmanuelkech.todolist.R
import com.emmanuelkech.todolist.databinding.FragmentTaskListBinding
import com.emmanuelkech.todolist.databinding.ListItemBinding

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    companion object {
        var taskTitle = arrayListOf(
            "Draw the map", "Charge your tab", "Microwave lunch"
        )

        var taskDescription = arrayListOf(
            "Use the newly acquired sketch pad and pens to draw up the map",
            "The tab is in the bed drawer. Don't forget to charge",
            "lunch is in the upper right corner of the freezer"
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val taskListBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(taskListBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.allViews(position)
    }

    override fun getItemCount(): Int {
        return taskTitle.size
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun allViews(position: Int) {

            binding.taskTitle.text = taskTitle[position]

            binding.taskHolder.setOnClickListener {
                val title = taskTitle[position]
                val description = taskDescription[position]

                val bundle = Bundle()
                bundle.putString("TITLE", title)
                bundle.putString("DESCRIPTION", description)
                findNavController(binding.root).navigate(R.id.action_taskListFragment_to_taskDetailsFragment, bundle)
            }
        }
    }
}