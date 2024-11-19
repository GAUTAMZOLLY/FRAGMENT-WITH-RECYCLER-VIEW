package com.example.fragmentandrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment2 : Fragment() {
     private   lateinit var   userArrayList : ArrayList<ItemData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =   inflater.inflate(R.layout.fragment_2, container, false)
        val workerName = arrayOf(
            "Alice Johnson" ,
            "Bob Smith" ,
            "Charlie Brown"  ,
            "Diana Lee" ,
            "Ethan Harris" ,
            "Fiona Clark" ,
            "George Walker" ,
            "Hannah Allen" ,
            "Iris Turner" ,
            "James Scott"
        )

        val workerPhoto  = arrayOf(
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
              R.drawable.man  ,
        )

         userArrayList =  ArrayList()

        for (i in workerPhoto.indices)  {
              val view =  ItemData(workerPhoto[i] , workerName[i])
             userArrayList.add(view)
        }

         val recyclerView2 : RecyclerView =  view.findViewById(R.id.workerRecyclerView)
         recyclerView2.layoutManager =  LinearLayoutManager(requireContext())
         val setAdapter  = MyAdapter(requireActivity() ,  userArrayList)
         recyclerView2.adapter  = setAdapter

         setAdapter.setOnItemClickListener(object  : MyAdapter.OnItemClickListener{
             override fun onItemClick(position: Int) {
                 Toast.makeText(requireContext() , "Okay done" , Toast.LENGTH_SHORT).show()

             }

         })
         return  view
    }
}