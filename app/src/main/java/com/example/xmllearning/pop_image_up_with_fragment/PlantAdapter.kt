package com.example.xmllearning.pop_image_up_with_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R
import com.example.xmllearning.databinding.PlantItemBinding


class PlantAdapter(private val fragment: ArticleFragment2) : RecyclerView.Adapter<PlantViewHolder>() {

    val plantList = ArrayList<Plant>()

//    class PlantViewHolder(item: View, private val fragment: ArticleFragment2) : RecyclerView.ViewHolder(item) {
//        val binding = PlantItemBinding.bind(item)
//
//        fun bind(plant: Plant) = with(binding){
//            imView.setImageResource(plant.imageId)
//            tvTitle.text = plant.title
//
//            // Добавляем обработчик клика на ImageView
//            imView.setOnClickListener {
//                fragment.showImagePopUp(plant)
//            }
//
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantViewHolder(view, fragment)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(plantList[position])
    }

    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}