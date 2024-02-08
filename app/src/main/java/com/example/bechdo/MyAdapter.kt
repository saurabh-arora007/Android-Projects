package com.example.bechdo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productList: List<Product>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        /* If Layout Manager fails to create view for some data,
           then this method is used */

        val  itemView = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // return size of the list
        return productList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Once we got the data, this method will populate data into the view
        val currData = productList[position]

        holder.title.text = currData.title
        Picasso.get()
            .load(currData.thumbnail)
            .into(holder.image)
        holder.description.text = currData.description
        holder.price.text = currData.price.toString()


    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //this method hold the view for us

        val image : ImageView
        val title : TextView
        val description : TextView
        val price : TextView

        init {
            image = itemView.findViewById(R.id.siv_product_image)
            image.clipToOutline = true
            title = itemView.findViewById(R.id.tv_product_name)
            description = itemView.findViewById<TextView?>(R.id.tv_product_description)
            description.isSelected = true
            price = itemView.findViewById(R.id.tv_product_price)

        }

    }
}