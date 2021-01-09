package com.example.KulinerMantap.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.KulinerMantap.databinding.ItemListBinding
import com.example.KulinerMantap.pojo.KulinerItem

class ListKulinerViewHolder(val bind: ItemListBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(data: KulinerItem){

        bind.textTitle.text= data.nama
        bind.textAlamat.text = data.alamat
//        bind.imgHeadline.setImageURI(data.gambarUrl?.toUri())
//        bind.imgHeadline.setImageURI(data.gambarUrl)
        Glide.with(bind.root.context).load(data.gambarUrl).into(bind.imgHeadline)
    }
}