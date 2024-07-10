package com.example.rickandmortyapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.adapters.CharactersAdapter
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.data.RetrofitService
import com.example.rickandmortyapp.data.ResultCharacters
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.utils.RetrofitProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharactersAdapter
    private var charactrsList:List<ResultCharacters> = listOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CharactersAdapter(emptyList()) {

        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        initSearchView(menu?.findItem(R.id.menu_search))

        return true
    }
    private fun initSearchView(searchItem: MenuItem?) {
        if (searchItem != null) {
            var searchView = searchItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchByName(query!!)
                    searchView.clearFocus()
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    return false
                }
            })
        }
    }



    private fun navigateToDetail(characters: ResultCharacters) {
        //Toast.makeText(this, superhero.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Detail::class.java)
        intent.putExtra("CHARACTER_ID", characters.id)
        startActivity(intent)
    }










    private fun searchByName(query: String) {


        val service: RetrofitService = RetrofitProvider.getRetrofit()

        CoroutineScope(Dispatchers.IO).launch {

            val response = service.searchByName(query)

            runOnUiThread {

                if (response.isSuccessful) {
                    Log.i("HTTP", "respuesta correcta :)")
                    charactrsList = response.body()?.results.orEmpty()
                    adapter.updateItems(charactrsList)

                } else {
                    Log.i("HTTP", "respuesta erronea :(")
                    Toast.makeText(this@MainActivity, "Hubo un error inesperado, vuelva a intentarlo más tarde", Toast.LENGTH_LONG).show()
                }
            }
        }
    }




}