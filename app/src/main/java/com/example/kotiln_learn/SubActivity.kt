package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotiln_learn.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private var mBinding: ActivitySubBinding? = null   // 전역 변수로 바인딩 객체 선언
    private val binding get() = mBinding!!      // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivitySubBinding.inflate(layoutInflater)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의 인스턴스를 활용하여 생선된 뷰를 액티비티에 표시.
        setContentView(binding.root)


        if (intent.hasExtra("msg")){
            var getMsg = intent.getStringExtra("msg")
            binding.tvGetMsg.setText(getMsg)    // 서브 엑티비티에 존재하는 텍스트뷰에 글이 넣어
        }
    }
}