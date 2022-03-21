package com.example.kotiln_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = tab_layout
        val viewpager2 = view_pager_2

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewpager2.adapter = adapter
        viewpager2.orientation = ViewPager2.ORIENTATION_VERTICAL

        TabLayoutMediator(tabLayout, viewpager2){ tab , position ->
            when(position){
                0 -> {
                    tab.text = "First"
                }
                1 -> {
                    tab.text = "Second"
                }
                2 -> {
                    tab.text = "Third"
                }
            }
        }.attach()
    }
}