package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
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

        binding.webView.settings.javaScriptEnabled = true       // 자바스크립트 허용

        /* 웹 뷰에서 새창이 뜨지 않도록 방지하는 구문 */
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        /* 웹 뷰에서 새창이 뜨지 않도록 방지하는 구문 */

        binding.webView.loadUrl("https://www.naver.com")
        }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()){    // 웹사이트에서 뒤로 갈 페이지가 존재 한다면...
            binding.webView.goBack()
        }else{
            super.onBackPressed()           // 뒤로갈 페이지가 없다면 원래 뒤로가기 기능 실행
        }
    }
}