package com.ankitgupta.dev.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView



class LikesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
val text :TextView = view.findViewById(R.id.likes_Count)
             val  img  :AppCompatImageView = view.findViewById(R.id.likes_Image)

        val progressBar: ProgressBar = view.findViewById(R.id.progress)

        var count = 0
  img.setOnClickListener {
  count++

if (count>=1){
progressBar.visibility = View.VISIBLE
    progressBar.progress = count
    progressBar.max = 100
    text.text = count.toString()
    if (count==10){
        Toast.makeText(view.context,"keep going",Toast.LENGTH_SHORT).show()
    }
    if (count==20){
        Toast.makeText(view.context,"Excellent",Toast.LENGTH_SHORT).show()
    }

}

  }

}
}

//    private fun extracted(img: AppCompatImageView,view: View) {
//
//         }
