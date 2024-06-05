package com.example.xmllearning.pop_image_up_with_fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.databinding.PlantItemBinding


class PlantViewHolder(item: View, private val fragment: ArticleFragment2) : RecyclerView.ViewHolder(item) {
    val binding = PlantItemBinding.bind(item)

    fun bind(plant: Plant) = with(binding){
        imView.setImageResource(plant.imageId)
        tvTitle.text = plant.title

        // Добавляем обработчик клика на ImageView
        imView.setOnClickListener {
            fragment.showImagePopUp(plant)
        }

    }
}