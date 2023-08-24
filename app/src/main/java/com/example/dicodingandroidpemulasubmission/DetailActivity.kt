package com.example.dicodingandroidpemulasubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingandroidpemulasubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    private var waifuData : Waifu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        waifuData = intent.getParcelableExtra<Waifu>("data")
        supportActionBar?.title = waifuData?.waifuName.toString()
        setContentView(binding.root)
    }
}