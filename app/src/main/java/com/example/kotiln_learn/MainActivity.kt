package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.kotiln_learn.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

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

        loadData()
        }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()

        savaData()
    }

    private fun savaData() {
        // editText 값을 저장한다.
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()      // 수정 모드
        edit.putString("name", binding.etHello.text.toString())      // 1번째 인자는 키값을, 2번째 인자에는 실제 담아둘 값
        edit.apply()        // 저장 완료
    }

    private fun loadData() {
        // editText 값을 불러와서 다시 넣어준다.
        val pref = getSharedPreferences("pref", 0)

        // 첫번째 인자에서는 저장할 당시의 키 값을 입력, 2번째는 키 값에 데이터가 졵하지 않을 경우 대체 값을 저장한다.
        binding.etHello.setText(pref.getString("name", ""))
    }
}