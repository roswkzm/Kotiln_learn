package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pager_layout1.*
import kotlinx.android.synthetic.main.pager_layout1.view.*

class MainActivity : AppCompatActivity() {

    val bgColors: MutableList<Int> = mutableListOf(
        android.R.color.holo_red_light,
        android.R.color.holo_green_light,
        android.R.color.holo_blue_dark
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = CustomPagerAdapter()

        //어댑터 적용
        viewPager1.adapter = mAdapter

        //가로 방향 스크롤링
        viewPager1.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        btn_orientaition.setOnClickListener {
            val newBgColor = intArrayOf(
                android.R.color.darker_gray,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark
            ).random()
            bgColors.add(newBgColor)

            if ( viewPager1.orientation == ViewPager2.ORIENTATION_HORIZONTAL){
                btn_orientaition.text = "가로 방향 스크롤"
                viewPager1.orientation = ViewPager2.ORIENTATION_VERTICAL
            }else if(viewPager1.orientation == ViewPager2.ORIENTATION_VERTICAL){
                btn_orientaition.text = "세로 방향 스크롤"
                viewPager1.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            }

            //데이터가 변경되었음을 어댑터에 알림
            viewPager1.adapter?.notifyDataSetChanged()
        }


        viewPager1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                tv_toolbar.text = "$position 페이지"
                super.onPageSelected(position)
            }
        })


    }

    inner class CustomPagerAdapter : RecyclerView.Adapter<CustomPagerAdapter.MyPagerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.pager_layout1, parent, false)
            return MyPagerViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
            val textView1 = holder.itemView.textView
            textView1.text = "어댑터 : $position 페이지"
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, bgColors[position]))
        }

        override fun getItemCount(): Int {
            return bgColors.size
        }

        inner class MyPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        }

    }

}