package com.example.dicodingproject

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataPlayer = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Player>("key_player", Player::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Player>("key_player")
        }

        val detailName = findViewById<TextView>(R.id.name_view)
        val detailUmur = findViewById<TextView>(R.id.umur_view)
        val detailNegara = findViewById<TextView>(R.id.negara_view)
        val detailPosisi = findViewById<TextView>(R.id.posisi_view)
        val detailImg = findViewById<ImageView>(R.id.image_view)
        val detailDesc = findViewById<TextView>(R.id.desc_view)

        detailName.text = dataPlayer?.name
        detailUmur.text = dataPlayer?.umur
        detailNegara.text = dataPlayer?.negara
        detailPosisi.text = dataPlayer?.posisi
        dataPlayer?.image?.let { detailImg.setImageResource(it) }
        detailDesc.text = dataPlayer?.description
    }
}