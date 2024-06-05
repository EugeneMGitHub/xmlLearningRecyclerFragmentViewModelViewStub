package com.example.xmllearning.fragment_learning1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.xmllearning.R
import com.example.xmllearning.databinding.FragmentLearningActivityBinding


class FragmentLearningActivity : AppCompatActivity() {
    private lateinit var binding: FragmentLearningActivityBinding
    private val viewModel: ViewModelLearning by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = FragmentLearningActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**Можем сделать фрагмент так*/
        // Это замещает все то что было в R.id.place_holder на содержимое Fragment1
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, Fragment1.newInstance())
            .commit()
        /**Можем сделать фрагмент так*/

        /**А можем так*/
        // openFragment(fragment = Fragment1.newInstance(), idHolder = R.id.place_holder)
        /**А можем так*/

        // Вставляем второй фрагмент
        openFragment(fragment = Fragment2.newInstance(), idHolder = R.id.place_holder2)


        viewModel.messageForActivity.observe( this) { it ->
            binding.textView.text = it
        }


    }


    private fun openFragment(fragment: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, fragment)
            .commit()
    }

}