package com.example.kotiln_learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotiln_learn.databinding.ActivityFirstFragmentBinding

class FirstFragment : Fragment() {
    private lateinit var firstFragmentBinding: ActivityFirstFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        firstFragmentBinding = ActivityFirstFragmentBinding.inflate(inflater,container,false)


        firstFragmentBinding.fragTv.text = "성공"
        return firstFragmentBinding.root
    }
}