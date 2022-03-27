package com.example.kotiln_learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotiln_learn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(mainBinding.mainFrame.id, FirstFragment()).commit()
        }
    }
}