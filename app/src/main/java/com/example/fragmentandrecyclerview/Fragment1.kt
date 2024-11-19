package com.example.fragmentandrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment() {
    private lateinit var  userArrayList : ArrayList<ItemData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =   inflater.inflate(R.layout.fragment_1, container, false)
          val imageArray  = arrayOf(
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
                R.drawable.woman ,
          )

        val nameArray =  arrayOf(
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
        )

        userArrayList = ArrayList()

        for (i in imageArray.indices) {
              val view =  ItemData(imageArray[i] , nameArray[i])
             userArrayList.add(view)
        }

        val recyclerView : RecyclerView = view.findViewById(R.id.myRecyclerView_Id)
         recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val setAdapter =  MyAdapter(requireActivity() , userArrayList)
         recyclerView.adapter =  setAdapter

         setAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener{
             override fun onItemClick(position: Int) {
                 Toast.makeText(requireContext() , "okay" , Toast.LENGTH_SHORT).show()
             }

         })
        return  view
    }

}