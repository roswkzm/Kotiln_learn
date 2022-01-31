package com.example.kotiln_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.btnA.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)    // Intent 사용
            intent.putExtra("msg", binding.tvSendMsg.text.toString())   // putExtra 사용
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}