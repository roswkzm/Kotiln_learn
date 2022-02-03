package com.example.kotiln_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kotiln_learn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.android, "이진영1", "21", "리스트뷰리스트1"),
        User(R.drawable.android, "이진영2", "22", "리스트뷰리스트2"),
        User(R.drawable.android, "이진영3", "23", "리스트뷰리스트3"),
        User(R.drawable.android, "이진영4", "24", "리스트뷰리스트4"),
        User(R.drawable.android, "이진영5", "25", "리스트뷰리스트5"),
        User(R.drawable.android, "이진영6", "26", "리스트뷰리스트6"),
        User(R.drawable.android, "이진영7", "27", "리스트뷰리스트7")
    )

    private var mBinding: ActivityMainBinding? = null   // 전역 변수로 바인딩 객체 선언
    private val binding get() = mBinding!!      // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 인스턴스를 활용하여 생선된 뷰를 액티비티에 표시.
        setContentView(binding.root)

//        val item = arrayOf("사과", "딸기", "포도", "배", "키위")
//        // 리스트 뷰에 대한 어댑터 지정
//        binding.listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter;

        //만약 리스트뷰의 객체를 클릭하고싶다면...
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name, Toast.LENGTH_SHORT).show();

        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}