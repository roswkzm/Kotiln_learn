package com.example.kotiln_learn.fragments

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotiln_learn.R
import kotlinx.android.synthetic.main.activity_first_fragment.*
import kotlinx.android.synthetic.main.activity_first_fragment.view.*

class FirstFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_first_fragment,container,false)

        view.textView1.text = "승현이형"

        return view
    }
}