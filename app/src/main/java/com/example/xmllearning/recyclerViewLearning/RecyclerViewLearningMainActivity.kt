package com.example.xmllearning.recyclerViewLearning

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.xmllearning.R
import com.example.xmllearning.databinding.FragmentLearningActivityBinding
import com.example.xmllearning.databinding.ImagePopUpBinding
import com.example.xmllearning.databinding.RecyclerViewLearningMainBinding

class RecyclerViewLearningMainActivity : AppCompatActivity() {
    private lateinit var binding: RecyclerViewLearningMainBinding
    private var inflatedView: View? = null
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
    )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RecyclerViewLearningMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@RecyclerViewLearningMainActivity, 3)
            rcView.adapter = adapter

            buttonAdd.setOnClickListener {
                if(index > 2) index = 0
                val plant = Plant(imageIdList[index], "Plant $index")
                adapter.addPlant(plant)
                index++
            }
        }
    }


    private fun showPopUp(plant: Plant) {

        if (inflatedView == null) {
            inflatedView = binding.viewStub.inflate()
        } else {
            inflatedView?.visibility = View.VISIBLE
        }


        val closeIcon = inflatedView?.findViewById<ImageView>(R.id.close_icon_id)
        closeIcon?.setOnClickListener {
            inflatedView?.visibility = View.GONE
        }


//        val popUpBinding = ImagePopUpBinding.inflate(layoutInflater)
//        popUpBinding.photoImageView.setImageResource(plant.imageId)
//        val viewStub = binding.viewStub.inflate()
//        viewStub.visibility = View.VISIBLE
//        viewStub.findViewById<View>(R.id.close_icon_id).setOnClickListener {
//            viewStub.visibility = View.GONE
//        }
//        val cardView = viewStub.findViewById<View>(R.id.cardView)
//        cardView.visibility = View.VISIBLE
//        cardView.setOnClickListener {
//            viewStub.visibility = View.GONE
//        }
    }

}