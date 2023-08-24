package com.example.dicodingandroidpemulasubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingandroidpemulasubmission.databinding.ActivityAboutBinding
import com.example.dicodingandroidpemulasubmission.databinding.ActivityMainBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        supportActionBar?.title = "About Page"
        setContentView(binding.root)
    }
}