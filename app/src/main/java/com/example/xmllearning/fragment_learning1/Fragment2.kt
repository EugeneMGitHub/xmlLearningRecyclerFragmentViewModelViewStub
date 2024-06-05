package com.example.xmllearning.fragment_learning1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.xmllearning.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private val viewModel: ViewModelLearning by activityViewModels()
    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.messageForFragment2.observe(activity as LifecycleOwner){ it ->
                binding.tvMessage.text = it
        }


        binding.btnSendTofragment1.setOnClickListener {
            viewModel.messageForFragment1.value = "Hello from fragment 2"
        }
        binding.btnSendToActivity.setOnClickListener {
            viewModel.messageForActivity.value = "Activity, hello from fragment 2"
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}