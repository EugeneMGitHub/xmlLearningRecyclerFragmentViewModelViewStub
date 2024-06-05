package com.example.xmllearning.pop_image_up_with_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmllearning.R
import com.example.xmllearning.databinding.FragmentArticle2Binding


class ArticleFragment2 : Fragment() {


    private val viewModel: ArticleViewModel by activityViewModels()
    private lateinit var binding: FragmentArticle2Binding
    private lateinit var plantAdapter: PlantAdapter
    private var inflatedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantAdapter = PlantAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentArticle2Binding.inflate(inflater)
        // Настройка RecyclerView
        binding.resView.layoutManager = LinearLayoutManager(context)
        binding.resView.adapter = plantAdapter

        // Добавление данных в адаптер
        populatePlants()


        return binding.root


    }



    private fun populatePlants() {
        val plants = listOf(
            Plant(R.drawable.plant1, "Plant 1"),
            Plant(R.drawable.plant2, "Plant 2"),
            Plant(R.drawable.plant3, "Plant 3")
            // Добавьте сюда больше растений по мере необходимости
        )

        plantAdapter.plantList.addAll(plants)
        plantAdapter.notifyDataSetChanged()
    }

    fun showImagePopUp(plant: Plant) {

        if (inflatedView == null) {
            inflatedView = binding.viewStub.inflate()
        } else {
            inflatedView?.visibility = View.VISIBLE
        }

        // Найдем ImageView в раздутом макете и установим изображение
        val photoImageView = inflatedView?.findViewById<ImageView>(R.id.photoImageView)
        photoImageView?.setImageResource(plant.imageId)


        // Найдем крестик в раздутом макете и добавим для него слушатель событий
        val closeIcon = inflatedView?.findViewById<ImageView>(R.id.close_icon_id)
        closeIcon?.setOnClickListener {
            inflatedView?.visibility = View.GONE
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = ArticleFragment2()
    }
}