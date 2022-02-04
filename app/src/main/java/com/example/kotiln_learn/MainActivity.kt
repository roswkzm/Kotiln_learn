package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotiln_learn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null   // 전역 변수로 바인딩 객체 선언
    private val binding get() = mBinding!!      // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 인스턴스를 활용하여 생선된 뷰를 액티비티에 표시.
        setContentView(binding.root)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "이진영1", 11, "학생1"),
            Profiles(R.drawable.man, "이진영2", 12, "학생2"),
            Profiles(R.drawable.man, "이진영3", 13, "학생3"),
            Profiles(R.drawable.man, "이진영4", 14, "학생4"),
            Profiles(R.drawable.man, "이진영5", 15, "학생5"),
            Profiles(R.drawable.man, "이진영6", 16, "학생6"),
            Profiles(R.drawable.man, "이진영7", 17, "학생7"),
            Profiles(R.drawable.man, "이진영8", 18, "학생8"),
            Profiles(R.drawable.man, "이진영9", 19, "학생9"),
            Profiles(R.drawable.man, "이진영10", 20, "학생10"),
            Profiles(R.drawable.man, "이진영11", 21, "학생11"),
            Profiles(R.drawable.man, "이진영12", 22, "학생12"),
            Profiles(R.drawable.man, "이진영13", 23, "학생13")
        )
        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvProfile.setHasFixedSize(true)     // recyclerView 성능개선

        // RecyclerView와 어댑터의 실제 연결부
        binding.rvProfile.adapter = ProfileAdapter(profileList)
        }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}