package com.example.rickandmortyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rickandmortyapp.data.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val urlBase = "https://rickandmortyapi.com/api/character/"

        fun getRetrofit(): Retrofit{
                return Retrofit
                    .Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()






        }


        }

    private fun searchByName(query: String){
        CoroutineScope(Dispatchers.IO).launch {
        val myResponsive = retrofit.create(RetrofitService::class.java).getCharactersList(query)
            runOnUiThread{

                if (myResponsive.isSuccessful){
                    Log.i("PETICION", "Correcta")
                }else
                    Log.i("PETICION", "Incorrecta")


            }

            }




        searchByName("rick")
    }


    }