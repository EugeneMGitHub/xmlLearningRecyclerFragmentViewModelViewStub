package com.example.xmllearning.pop_image_up_with_fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.xmllearning.R
import com.example.xmllearning.databinding.ActivityArticleBinding
import com.example.xmllearning.fragment_learning1.Fragment1


class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder_arcticle, ArticleFragment2.newInstance())
            .commit()
    }
}