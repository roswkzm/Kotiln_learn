package com.example.kotiln_learn.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotiln_learn.R
import kotlinx.android.synthetic.main.activity_third_fragment.view.*

class ThirdFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_third_fragment,container,false)

        view.textView3.text = "푱신"

        return view
    }
}