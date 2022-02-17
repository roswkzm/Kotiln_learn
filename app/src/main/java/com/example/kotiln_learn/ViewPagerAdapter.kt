package com.example.kotiln_learn

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotiln_learn.fragments.FirstFragment
import com.example.kotiln_learn.fragments.SecFragment
import com.example.kotiln_learn.fragments.ThirdFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecFragment()
            }
            2 -> {
                ThirdFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}