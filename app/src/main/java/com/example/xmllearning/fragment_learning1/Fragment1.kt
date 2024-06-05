package com.example.xmllearning.fragment_learning1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.xmllearning.databinding.Fragment1Binding

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {

    private val viewModel: ViewModelLearning by activityViewModels()
    lateinit var binding: Fragment1Binding


    // TODO: Rename and change types of parameters
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.messageForFragment1.observe(activity as LifecycleOwner){ it ->
            binding.textView.text = it
        }

        binding.btnSendTofragment2.setOnClickListener {
        viewModel.messageForFragment2.value = "Hello from fragment 1"
       }
        binding.btnSendToActivity.setOnClickListener {
            viewModel.messageForActivity.value = "Activity, hello from fragment 1"
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = com.example.xmllearning.fragment_learning1.Fragment1()
    }
}