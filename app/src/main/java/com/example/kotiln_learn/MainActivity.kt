package com.example.kotiln_learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.kotiln_learn.ApiRequest.Companion.BASE_URL
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)

        api.getApi().enqueue(object : Callback<ApiData>{
            override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
                Log.d("ㅎㅇㅎㅇ1", response.body()?.resultCode.toString())
                Log.d("ㅎㅇㅎㅇ1", response.body()?.resultMessage.toString())
                textView.text = response.body()?.korea.toString()
            }

            override fun onFailure(call: Call<ApiData>, t: Throwable) {
            }
        })

    }
}