package com.example.fragmentandrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragmentandrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
      private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

           binding.studentButton.setOnClickListener {
                 goToFragment(Fragment1())
           }
         binding.workerBtn.setOnClickListener {
               goToFragment(Fragment2())
         }

    }
     private  fun  goToFragment(fragment: Fragment)  {
          val fragmentManager  = supportFragmentManager
          fragmentManager.beginTransaction().replace(R.id.fragmentContainerView , fragment).commit()
     }

}