package com.example.dicodingproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private val list = ArrayList<Player>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        list.addAll(getListPlayer())
        showRv()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AbousUsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListPlayer() : ArrayList<Player> {
        val nameData = resources.getStringArray(R.array.data_player)
        val umurData = resources.getStringArray(R.array.data_umur_player)
        val negaraData = resources.getStringArray(R.array.negara_player)
        val posisiData = resources.getStringArray(R.array.data_posisi)
        val descData = resources.getStringArray(R.array.data_description)
        val playerImg = resources.obtainTypedArray(R.array.data_image)
        val listPlayer = ArrayList<Player>()
        for (i in nameData.indices) {
            val player = Player(nameData[i], umurData[i], negaraData[i], posisiData[i], playerImg.getResourceId(i, -1), descData[i])
            listPlayer.add(player)
        }
        return listPlayer
    }


    private fun showRv() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = PlayerAdapter(list)
        recyclerView.adapter = listPlayerAdapter
    }
}