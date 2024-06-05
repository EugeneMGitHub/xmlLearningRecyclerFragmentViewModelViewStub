package com.example.xmllearning.fragment_learning1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLearning : ViewModel() {

    // с помощью by lazy при созаваднии класса ViewModelLearning val message не будет пересоздаваться
    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFragment1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFragment2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}