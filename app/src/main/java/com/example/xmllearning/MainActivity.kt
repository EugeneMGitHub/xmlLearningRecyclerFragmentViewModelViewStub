package com.example.xmllearning

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.xmllearning.databinding.ImageViewWithCardBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ImageViewWithCardBinding

    private var inflatedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.justBtnId.setOnClickListener {
            binding.justBtnId.text = "Нажали на кнопку"
        }

        // Устанавливаем обработчик нажатия на карточку
        binding.cardViewId.setOnClickListener {
//            Toast.makeText(this, "Вы нажали на карточку", Toast.LENGTH_SHORT).show()

            if (inflatedView == null) {
                inflatedView = binding.viewStub.inflate()
            } else {
                inflatedView?.visibility = View.VISIBLE
            }

            // Найдем крестик в раздутом макете и добавим для него слушатель событий
            val closeIcon = inflatedView?.findViewById<ImageView>(R.id.close_icon_id)
            closeIcon?.setOnClickListener {
                inflatedView?.visibility = View.GONE
            }
        }
    }




}