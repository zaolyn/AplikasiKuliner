package com.example.kulinerapp.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kulinerapp.databinding.ItemListBinding
import com.example.kulinerapp.pojo.KulinerItem
import com.google.android.material.card.MaterialCardView

class ListKulinerViewHolder(val bind: ItemListBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(data: KulinerItem){

        bind.textTitle.text= data.nama
        bind.textAlamat.text = data.alamat
//        bind.imgHeadline.setImageURI(data.gambarUrl?.toUri())
//        bind.imgHeadline.setImageURI(data.gambarUrl)
        Glide.with(bind.root.context).load(data.gambarUrl).into(bind.imgHeadline)
    }
}