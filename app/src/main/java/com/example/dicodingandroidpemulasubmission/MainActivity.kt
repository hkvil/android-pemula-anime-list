package com.example.dicodingandroidpemulasubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingandroidpemulasubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        recyclerView = binding.recylerViewMain
        supportActionBar?.title = "My Waifu List"
        setContentView(binding.root)

        showRecyclerView(getWaifuData())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.action_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_profil->{
                val intent = Intent(this,AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun getWaifuData(): ArrayList<Waifu> {

        val waifuArray = ArrayList<Waifu>()

        val waifuName = resources.getStringArray(R.array.data_name)
        val waifuVoiceActor = resources.getStringArray(R.array.data_voiced_by)
        val waifuAge = resources.getStringArray(R.array.data_age)
        val waifuIntro = resources.getStringArray(R.array.data_intro)
        val waifuAnimeTitle = resources.getStringArray(R.array.data_anime_title)
        val waifuBirthday = resources.getStringArray(R.array.data_birth_day)
        val waifuPhoto = resources.obtainTypedArray(R.array.data_waifu_photo)
        //waifuPhoto.recycle()
        val waifuVoiceActorPhoto = resources.obtainTypedArray(R.array.data_voice_photo)
        //waifuVoiceActorPhoto.recycle()

        for (i in waifuName.indices) {
            waifuArray.add(
                Waifu(
                    waifuName[i],
                    waifuVoiceActor[i],
                    waifuAge[i],
                    waifuIntro[i],
                    waifuAnimeTitle[i],
                    waifuBirthday[i],
                    waifuPhoto.getResourceId(i, -1),
                    waifuVoiceActorPhoto.getResourceId(i, -1)
                )
            )
        }

        return waifuArray
    }//end getWaifuData()
    private fun showRecyclerView(waifuList:ArrayList<Waifu>){
        val listWaifuAdapter = WaifuAdapter(waifuList)
        recyclerView.adapter = listWaifuAdapter
    }
}