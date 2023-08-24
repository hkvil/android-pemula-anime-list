package com.example.dicodingandroidpemulasubmission

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingandroidpemulasubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    private lateinit var waifuData :Waifu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        waifuData = intent.getParcelableExtra<Waifu>("data")!!

        supportActionBar?.title = waifuData.waifuName.toString()
        setupWaifuData()
        setContentView(binding.root)

        binding.actionShare.setOnClickListener{
            onClickedShare()
        }
    }

    private fun onClickedShare() {
        val waifuString = """
            Name       :${waifuData.waifuName}
            Age        :${waifuData.waifuAge}
            Anime      :${waifuData.waifuAnimeTitle}
            Birthday   :${waifuData.waifuBirthday}
            Voice Actor:${waifuData.waifuVoiceActor}
        """.trimIndent()
        val intent = Intent(Intent.ACTION_SEND).apply {
            //data = Uri.parse("smsto:")  // This ensures only SMS apps respond
            putExtra(Intent.EXTRA_TEXT, waifuString)
        }
        startActivity(intent)
    }



    private fun setupWaifuData() {
        binding.textViewWaifuName.text = waifuData.waifuName
        binding.textViewWaifuAge.text = waifuData.waifuAge
        binding.textViewWaifuAnimeTitle.text = waifuData.waifuAnimeTitle
        binding.textViewWaifuBirthday.text = waifuData.waifuBirthday
        binding.imageViewVoiceActor.setImageResource(waifuData.waifuVoiceActorPhoto)
        binding.textViewVoiceActorValue.text = waifuData.waifuVoiceActor
        binding.textViewIntroduction.text = waifuData.waifuIntro
        binding.imageViewWaifu.setImageResource(waifuData.waifuPhoto)
    }
}