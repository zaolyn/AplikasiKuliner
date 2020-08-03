package com.example.kulinerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kulinerapp.databinding.ActivityDetailKulinerBinding
import com.example.kulinerapp.pojo.KulinerItem
import kotlinx.android.synthetic.main.activity_detail_kuliner.*

class DetailKuliner : AppCompatActivity() {

    private lateinit var binding : ActivityDetailKulinerBinding
    private lateinit var dataIntent : KulinerItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = layoutInflater
        binding = ActivityDetailKulinerBinding.inflate(inflater)
        setContentView(binding.root)
        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataIntent = intent.getParcelableExtra("KULINER_ITEM") as KulinerItem

        binding.namaKuliner.text = dataIntent.nama
        binding.textAlamat.text = dataIntent.alamat
        binding.textJamBuka.text = dataIntent.jamBukaTutup
        binding.textKategori.text = dataIntent.kategori
        Glide.with(binding.root.context).load(dataIntent.gambarUrl).into(gambar_kuliner)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}