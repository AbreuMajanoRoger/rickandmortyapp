package com.example.rickandmortyapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.adapters.CharactersAdapter
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.UserActivity
import com.example.rickandmortyapp.data.RetrofitService
import com.example.rickandmortyapp.data.ResultCharacters
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.utils.RetrofitProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CharactersAdapter
    lateinit var charactrsList: List<ResultCharacters>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        charactrsList = emptyList()

        adapter =
            CharactersAdapter(charactrsList) { position -> navigateToDetail(charactrsList[position]) }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.btnSub.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }



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

        val intent = Intent(this, Detail::class.java)
        intent.putExtra("EXTRA_ID", characters.id)
        startActivity(intent)
    }


    private fun searchByName(query: String) {


        val service: RetrofitService = RetrofitProvider.getRetrofit()

        CoroutineScope(Dispatchers.IO).launch {

            val response = service.searchByName(query)

            runOnUiThread {

                if (response.isSuccessful) {
                    Log.i("HTTP", "$response :(")
                    Log.i("HTTP", "respuesta correcta :)")
                    charactrsList = response.body()?.results.orEmpty()
                    adapter.updateData(charactrsList)

                } else {
                    Log.i("HTTP", "respuesta erronea :(")
                    Toast.makeText(
                        this@MainActivity,
                        "Hubo un error inesperado, vuelva a intentarlo más tarde",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }


}