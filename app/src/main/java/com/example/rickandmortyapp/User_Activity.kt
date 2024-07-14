package com.example.rickandmortyapp

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import com.example.rickandmortyapp.databinding.ActivityUserBinding
import com.example.rickandmortyapp.utils.UserPref

class User_Activity : AppCompatActivity() {

    lateinit var binding: ActivityUserBinding

    val shared = getSharedPreferences("Myprefef", Context.MODE_PRIVATE)
    val editor = shared.edit()

    fun getShar(){
        binding.btnSave.setOnClickListener {
            val name = binding.MynameUser.text.toString()
            val lastName = binding.apellido.text.toString()
            val correos = binding.correo.text.toString()
            val telefonos = binding.telefono.text.toString()
            val chex = binding.checkBox.isChecked

        }
    }

}