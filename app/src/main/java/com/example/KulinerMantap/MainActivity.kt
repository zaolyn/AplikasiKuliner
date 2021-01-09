package com.example.KulinerMantap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.KulinerMantap.adapter.ListKulinerAdapter
import com.example.KulinerMantap.databinding.ActivityMainBinding
import com.example.KulinerMantap.pojo.KulinerItem
import com.example.KulinerMantap.remote.KulinerInterface
import com.example.KulinerMantap.remote.RetrofitService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        binding = ActivityMainBinding.inflate(inflater)
        setContentView(binding.root)

        setSupportActionBar(binding.homeToolbar)
        supportActionBar?.setTitle(R.string.app_name)

        val adapterRV = ListKulinerAdapter()

        binding.rvKuliner.run{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRV
        }

//        binding.adapterRV.run{
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(this@MainActivity)
//
//            // gunakan recyclerview adappteryang telah didefinisikan sebelumnya
//            adapter = adapterRV
//        }

        lifecycleScope.launch {
            val retrofit = RetrofitService.buildService(KulinerInterface::class.java)
            val summary =retrofit.getSummary()
            if(summary.isSuccessful) {
                val dataCountry = summary.body()?.kuliner as List<KulinerItem>
                adapterRV.addData(dataCountry)
            }
        }

    }
}