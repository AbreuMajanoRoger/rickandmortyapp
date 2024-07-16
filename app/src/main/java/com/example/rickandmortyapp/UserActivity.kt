package com.example.rickandmortyapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {


    private lateinit var binding: ActivityUserBinding
    private  var MY_SHARED_PREF_NAME = "my_shared_pref"
    private var NAME = "name"
    private var LASTNAME = "lastname"
    private var PHONE = "phone"
    private var EMAIL ="emails"
    private var PRUEBATEX = "texto"

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            saveData()
        }


        binding.btncancelData.setOnClickListener{
            cancelData()
        }

        binding.iconInfo.setOnClickListener {
            infoData()
        }

        sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, MODE_PRIVATE)

        binding.textField.editText?.setText(sharedPref.getString(NAME, ""))
        binding.editTextName.setText(sharedPref.getString(NAME, ""))
        binding.phone.setText(sharedPref.getString(PHONE, ""))
        binding.apellido.setText(sharedPref.getString(LASTNAME, ""))
        binding.mail.setText(sharedPref.getString(EMAIL, ""))
    }








    private fun saveData() {

        val insertName = binding.editTextName.text.toString()
        val insertNumber = binding.phone.text.toString()
        val insertLastName = binding.apellido.text.toString()
        val insertEmail = binding.mail.text.toString()


        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putString(NAME, insertName)
        editor.putString(LASTNAME,insertLastName)
        editor.putString(EMAIL,insertEmail)
        editor.putString(PHONE,insertNumber)
        editor.apply()

        Toast.makeText(this,"Hola $insertName Sus datos fueron guardados correctamente", Toast.LENGTH_LONG).show()
        Log.i("SHAREDPREF","$insertName")
        Log.i("SHAREDPREF"," $NAME" )

    }







     private fun cancelData(){


        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.remove(NAME)
        editor.remove(LASTNAME)
         editor.remove(EMAIL)
         editor.remove(PHONE)
        editor.apply()

         Toast.makeText(this,"Sus datos fueron borrados correctamente", Toast.LENGTH_LONG).show()
         Log.i("SHAREDPREF"," ${sharedPref.getString(NAME, "")}")


         binding.editTextName.setText("")
         binding.phone.setText("")
         binding.apellido.setText("")
         binding.mail.setText("")


    }





fun infoData(){

    val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME,Context.MODE_PRIVATE)




    val builder = AlertDialog.Builder(this)
    builder.setTitle("Datos")
    val dataString = "Name: ${sharedPref.getString(NAME, "")}\n" +
            "Lastname: ${sharedPref.getString(LASTNAME, "")}\n" +
            "Phone: ${sharedPref.getString(PHONE, "")}\n" +
            "Email: ${sharedPref.getString(EMAIL, "")}"
    builder.setMessage(dataString)
    builder.setPositiveButton("Aceptar") { dialog, which ->
        // Acción al presionar el botón "Aceptar"
    }
    val dialog = builder.create()
    dialog.show()

}





}


