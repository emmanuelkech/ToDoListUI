package com.emmanuelkech.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emmanuelkech.todolist.R
import com.emmanuelkech.todolist.databinding.FragmentCallsDetailsBinding

class CallsDetailsFragment : Fragment() {

    private var binding: FragmentCallsDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentCallsDetailsBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val bundle = arguments
        binding!!.taskTitle.text = bundle?.getString("TITLE")
        binding!!.taskDescription.text = bundle?.getString("DESCRIPTION")
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            callDetails = this@CallsDetailsFragment
        }
    }

    fun goBack() {
        findNavController().navigate(R.id.action_callsDetailsFragment_to_taskListFragment)
    }
}