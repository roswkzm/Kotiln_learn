package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.kotiln_learn.fragments.Fragment1
import com.example.kotiln_learn.fragments.Fragment2
import kotlinx.android.synthetic.main.activity_screen_slide.*

private const val NUM_PAGES = 5

class ScreenSlideActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide)

        viewPager = pager

        val pagerAdapter = ScreenSlideAdapter(this)
        viewPager.adapter = pagerAdapter

        btn_orientation.setOnClickListener {
            if(viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL){
                btn_orientation.text = "가로 방향 스크롤"
                viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
            }else if(viewPager.orientation == ViewPager2.ORIENTATION_VERTICAL){
                btn_orientation.text = "세로 방향 스크롤"
                viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            }
        }

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class ScreenSlideAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment {
            if (position % 2 == 0){
                return Fragment1()
            }else{
                return Fragment2()
            }
        }
    }
}