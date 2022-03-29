package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotiln_learn.databinding.ActivityMainBinding
import com.example.kotiln_learn.databinding.ItemRecyclerBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.android, "이진영1", 11, "학생1"),
            Profiles(R.drawable.android, "이진영2", 12, "학생2"),
            Profiles(R.drawable.android, "이진영3", 13, "학생3"),
            Profiles(R.drawable.android, "이진영4", 14, "학생4"),
            Profiles(R.drawable.android, "이진영5", 15, "학생5"),
            Profiles(R.drawable.android, "이진영6", 16, "학생6"),
            Profiles(R.drawable.android, "이진영7", 17, "학생7"),
            Profiles(R.drawable.android, "이진영8", 18, "학생8"),
            Profiles(R.drawable.android, "이진영9", 19, "학생9"),
            Profiles(R.drawable.android, "이진영10", 20, "학생10"),
            Profiles(R.drawable.android, "이진영11", 21, "학생11"),
            Profiles(R.drawable.android, "이진영12", 22, "학생12"),
            Profiles(R.drawable.android, "이진영13", 23, "학생13")
        )

        mainBinding.rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainBinding.rvMain.adapter = RecyclerViewAdapter(profileList)

    }

    inner class RecyclerViewAdapter(var data : ArrayList<Profiles>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
        inner class ViewHolder(var binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewAdapter.ViewHolder {
            val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(p0.context),p0,false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(p0: RecyclerViewAdapter.ViewHolder, p1: Int) {
            p0.binding.tvJob.text = data[p1].name
            p0.binding.tvAge.text = data[p1].age.toString()
        }

        override fun getItemCount(): Int {
            return data.size
        }

    }
}