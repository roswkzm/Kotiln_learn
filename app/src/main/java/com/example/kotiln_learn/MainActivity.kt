package com.example.kotiln_learn

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotiln_learn.databinding.ActivityMainBinding
import com.example.kotiln_learn.databinding.ItemRecyclerBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val rvAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // mainBinding의 recyclerView에 대해 묶어주는 역활
        with(mainBinding){
            with(rvMain){
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                adapter = rvAdapter
                addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            }
        }

        // itemTouchHelper를 통해 스와이프와 이동할 수 있도록 만듬
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT){
            // 드래그로 RecyclerView 자료 순서바꾸기
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val fromPos = viewHolder.adapterPosition
                val toPos = target.adapterPosition
                rvAdapter.swapData(fromPos, toPos)
                return true
            }
            // 스와이프로 RecyclerView의 자료 삭제
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                rvAdapter.removeData(viewHolder.layoutPosition)
            }
            // 스와이프시 여백 채우기
            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                val icon : Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE){
                    val itemView = viewHolder.itemView
                    val height = (itemView.bottom - itemView.top).toFloat()
                    val width = height / 4
                    val paint = Paint()
                    // 왼쪽으로 스와이프 했을시
                    if (dX < 0){
                        // 색상추가
                        paint.color = Color.parseColor("#ff0000")
                        val background = RectF(itemView.right.toFloat() + dX,itemView.top.toFloat(),itemView.right.toFloat(),itemView.bottom.toFloat())
                        c.drawRect(background,paint)

                        // 아이콘 추가
                        icon = BitmapFactory.decodeResource(resources, R.drawable.android)
                        val iconDest = RectF(itemView.right.toFloat() -3 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width,
                            itemView.bottom.toFloat() - width)
                        c.drawBitmap(icon, null, iconDest, null)
                    }
                }
            }
        }
        // ItemTouchHelper를 RecyclerView에 연결
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(mainBinding.rvMain)

    }

    inner class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

        private val dataSet : ArrayList<List<String>> = arrayListOf<List<String>>().apply {
            for (i in 0 .. 99){
                add(listOf("$i th main", "$i th sub"))
            }
        }

        // 스와이프시 데이터 지워주는 함수
        fun removeData(position: Int){
            dataSet.removeAt(position)
            notifyItemRemoved(position)
        }

        fun swapData(fromPos : Int, toPos : Int){
            Collections.swap(dataSet,fromPos,toPos)
            notifyItemMoved(fromPos, toPos)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
            val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ViewHolder(binding)
        }

        inner class ViewHolder (var binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(data:List<String>){
                binding.tvMain.text = data[0]
                binding.tvSub.text = data[1]
            }
        }

        override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
            holder.bind(dataSet[position])
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }

    }
}