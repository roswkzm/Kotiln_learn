package com.example.kotiln_learn.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotiln_learn.R

class Fragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_fragment2,container,false)

        Toast.makeText(context, "gdgdgd", Toast.LENGTH_SHORT).show()

        return view
    }
}