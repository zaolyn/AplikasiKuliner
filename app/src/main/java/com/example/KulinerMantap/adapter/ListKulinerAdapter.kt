package com.example.KulinerMantap.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.KulinerMantap.DetailKuliner
import com.example.KulinerMantap.databinding.ItemListBinding
import com.example.KulinerMantap.pojo.KulinerItem

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