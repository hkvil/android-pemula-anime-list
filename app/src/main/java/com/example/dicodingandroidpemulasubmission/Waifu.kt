package com.example.dicodingandroidpemulasubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifu(
    val waifuName:String,
    val waifuVoiceActor:String,
    val waifuAge:String,
    val waifuIntro:String,
    val waifuAnimeTitle:String,
    val waifuBirthday:String,
    val waifuPhoto:Int,
    val waifuVoiceActorPhoto:Int
):Parcelable
