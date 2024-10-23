package com.example.dicodingproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val umur: String,
    val negara: String,
    val posisi: String,
    val image: Int,
    val description: String
) : Parcelable
