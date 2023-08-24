package com.example.dicodingandroidpemulasubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class WaifuAdapter(val list: ArrayList<Waifu>) :
    RecyclerView.Adapter<WaifuAdapter.WaifuViewHolder>() {

    class WaifuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var waifuName: TextView = itemView.findViewById(R.id.text_view_tite)
        private var waifuAnimeTitle: TextView = itemView.findViewById(R.id.text_view_secondary_text)
        private var waifuPhoto: ImageView = itemView.findViewById(R.id.image_view_main)

        fun bind(waifu: Waifu) {
            waifuName.text = waifu.waifuName
            waifuAnimeTitle.text = waifu.waifuAnimeTitle
            waifuPhoto.setImageResource(waifu.waifuPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaifuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return WaifuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: WaifuViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("data", list[position])
            }
            context.startActivity(intent)
            //Toast.makeText(context,list[position].waifuIntro,Toast.LENGTH_LONG).show()
        }
    }

}