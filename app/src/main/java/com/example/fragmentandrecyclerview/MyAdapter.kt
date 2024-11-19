package com.example.fragmentandrecyclerview

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val  context: Activity , private  val userArrayList : ArrayList<ItemData>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

        // implementation of itemClickListener
  private  lateinit var myListener: OnItemClickListener
   interface  OnItemClickListener{
         fun  onItemClick(position: Int)
   }
     fun  setOnItemClickListener(listener: OnItemClickListener){
             myListener =  listener
     }

    class MyViewHolder(itemView : View , listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
      val image : ImageView  =  itemView.findViewById(R.id.image_Id)
         val names : TextView  =  itemView.findViewById(R.id.name_id)

        init {
            itemView.setOnClickListener {
                  listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.item_view , parent , false)
         return MyViewHolder(itemView , myListener)
    }

    override fun getItemCount(): Int {
       return userArrayList.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val selectedItem =  userArrayList[position]
         holder.image.setImageResource(selectedItem.image)
         holder.names.text =  selectedItem.name
    }
}