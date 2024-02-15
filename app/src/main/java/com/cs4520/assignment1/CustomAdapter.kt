package com.cs4520.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: List<List<Any?>>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var productImageView: ImageView
        var productName: TextView
        var productPrice: TextView
        var productExpiryDate: TextView
        var backgroundColor: View
//        var productImage: View

        init {
            // Define click listener for the ViewHolder's View.
            productImageView = view.findViewById(R.id.productImageView)
            productName = view.findViewById(R.id.productName)
            productPrice = view.findViewById(R.id.productPrice)
            productExpiryDate = view.findViewById(R.id.productExpiryDate)
            backgroundColor = view.findViewById(R.id.cardColor)
//            productImage = view.findViewById(R.id.productImage)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if(dataSet[position][1] == "Food") {
            viewHolder.productImageView.setImageResource(R.drawable.food)
            viewHolder.productName.text = dataSet[position][0].toString()
            viewHolder.productPrice.text = dataSet[position][3].toString()
            viewHolder.productExpiryDate.text = dataSet[position][2].toString()
            viewHolder.backgroundColor.setBackgroundResource(R.color.foodBackgroundColor)
        }
        else if(dataSet[position][1] == "Equipment") {
            viewHolder.productImageView.setImageResource(R.drawable.equipment)
            viewHolder.productName.text = dataSet[position][0].toString()
            viewHolder.productPrice.text = dataSet[position][3].toString()
            viewHolder.productExpiryDate.text = ""
            viewHolder.backgroundColor.setBackgroundResource(R.color.equipmentBackgroundColor)
        }
    }
    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        if(dataSet[position][1] == "Food") {
            return 0
        }
        else if(dataSet[position][1] == "Equipment") {
            return 1

        }
        return -1
    }
}