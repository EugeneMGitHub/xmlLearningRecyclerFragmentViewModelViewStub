package com.example.xmllearning.pop_image_up_with_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xmllearning.R


class ArticleViewModel : ViewModel() {

    val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
    )

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