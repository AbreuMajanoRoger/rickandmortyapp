package com.example.rickandmortyapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.ResultCharacters
import com.example.rickandmortyapp.data.RetrofitService
import com.example.rickandmortyapp.databinding.ActivityDetailBinding
import com.example.rickandmortyapp.utils.RetrofitProvider
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Detail : AppCompatActivity() {


    lateinit var binding: ActivityDetailBinding
    lateinit var character: ResultCharacters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("SUPERHERO_ID", -1)

        getById(id)




    }

    private fun loadData() {
        binding.txtDetailTextName.text = character.name





    }

    private fun getById(id: Int) {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val service: RetrofitService = RetrofitProvider.getRetrofit()
                val result = service.getId(id)

                character
                runOnUiThread {
                    loadData()
                }

                runOnUiThread {
                    loadData()
                }
                //Log.i("HTTP", "${result.results}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }





}