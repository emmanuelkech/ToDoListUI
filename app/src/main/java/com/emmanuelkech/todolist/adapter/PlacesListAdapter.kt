package com.emmanuelkech.todolist.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.emmanuelkech.todolist.R
import com.emmanuelkech.todolist.databinding.ListItemBinding


class PlacesListAdapter : RecyclerView.Adapter<PlacesListAdapter.ViewHolder>() {

    companion object {
        var taskTitle = arrayListOf(
            "Visit Ghana", "Pickup your medicine"
        )

        var taskDescription = arrayListOf(
            "Join TSP travels to Ghana this year",
            "The store closes by 10PM. Don't be late"
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val callListBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(callListBinding)
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
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_taskListFragment_to_placesDetailsFragment, bundle)
            }
        }
    }
}