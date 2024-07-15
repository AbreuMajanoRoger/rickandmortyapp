package com.example.rickandmortyapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {


    private lateinit var binding: ActivityUserBinding
    private  var MY_SHARED_PREF_NAME = "my_shared_pref"
    private var NAME = "name"
    private var LASTNAME = "lastname"
    private var PHONE = "phone"
    private var EMAIL ="emails"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            saveData()
        }
    }








    private fun saveData() {

        val insertName = binding.editTextName.text.toString()
        val insertNumber = binding.phone.text.toString()
        val insertLastName = binding.apellido.text.toString()
        val insertEmail = binding.mail.text.toString()


        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putString(NAME, insertName)
        editor.putString(LASTNAME,insertLastName)
        editor.putString(EMAIL,insertEmail)
        editor.putString(PHONE,insertNumber)
        editor.apply()

        Toast.makeText(this,"Sus datos fueron guardados correctamente", Toast.LENGTH_LONG).show()

    }



}


