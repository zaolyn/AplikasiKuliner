package com.example.kulinerapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kulinerapp.DetailKuliner
import com.example.kulinerapp.databinding.ItemListBinding
import com.example.kulinerapp.pojo.KulinerItem

class ListKulinerAdapter : RecyclerView.Adapter<ListKulinerViewHolder>() {

    private val dataKuliner : MutableList<KulinerItem> =  mutableListOf<KulinerItem>()

    fun addData(listKuliner : List<KulinerItem>){
        dataKuliner.clear()
        dataKuliner.addAll(listKuliner)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKulinerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ItemListBinding.inflate(inflater, parent, false)
        return ListKulinerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  dataKuliner.size
    }

    override fun onBindViewHolder(holder: ListKulinerViewHolder, position: Int) {
        val data = dataKuliner[position]
        holder.bind(data)

        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, data.title, Toast.LENGTH_SHORT).show()
            val intent = Intent(it.context, DetailKuliner::class.java).apply {
                putExtra("KULINER_ITEM", data)
            }
            it.context.startActivity(intent)


        }
    }
}