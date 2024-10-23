package com.example.dicodingproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(private val listPlayer: ArrayList<Player>) : RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPlayer : ImageView = itemView.findViewById(R.id.imgPlayer)
        val namePlayer : TextView = itemView.findViewById(R.id.namePlayer)
        val umurPlayer : TextView = itemView.findViewById(R.id.umurPlayer)
        val negaraPlayer : TextView = itemView.findViewById(R.id.negaraPlayer)
        val posisiPlayer : TextView = itemView.findViewById(R.id.posisiPlayer)
        val descPlayer: TextView = itemView.findViewById(R.id.descPlayer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (name, umur, negara, posisi, image, desc) = listPlayer[position]
        holder.namePlayer.text = name
        holder.umurPlayer.text = umur
        holder.negaraPlayer.text = negara
        holder.posisiPlayer.text = posisi
        holder.imgPlayer.setImageResource(image)
        holder.descPlayer.text = desc

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_player", listPlayer[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}