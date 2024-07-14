package com.example.rickandmortyapp.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rickandmortyapp.data.CharactersDataResponsive
import com.example.rickandmortyapp.data.ResultCharacters
import com.example.rickandmortyapp.data.RetrofitService
import com.example.rickandmortyapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Detail : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var character: ResultCharacters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("EXTRA_ID", -1)

        getById(id)




    }

    private fun loadData() {
        Picasso.get().load(character.image).into(binding.imgCharacterDetail)

        binding.txtDetailName.text = character.name
        binding.txtGenderDetail.text = character.gender
        binding.txtStatusDetail.text = character.status
        binding.txtSpeciesDetail.text = character.species




    }


    private fun getById(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = getRetrofit().create(RetrofitService::class.java)
                val result = apiService.getId(id)

                character = result

                runOnUiThread {
                    Log.i("RESPUESTADETAIL", "${result}")
                    loadData()
                }
                //Log.i("HTTP", "${result.results}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }




}