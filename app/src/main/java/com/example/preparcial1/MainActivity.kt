package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarDatosSpinnerDesdeJSON()

        binding.btnPermisos.setOnClickListener {
            val intent = Intent(this, PermisosActivity::class.java)
            startActivity(intent)
        }

        binding.btnIntents.setOnClickListener {
            val intent = Intent(this, IntentsActivity::class.java)
            startActivity(intent)
        }

        binding.ticTacToe.setOnClickListener {
            startActivity(Intent(baseContext, TicTacToeActivity::class.java))
        }

        binding.randomGreet.setOnClickListener {
            val seleccion = binding.spinner.selectedItem.toString()
            val intent = Intent(baseContext, RandomGreetActivity::class.java)
            intent.putExtra("seleccion", seleccion)
            startActivity(intent)
        }

        binding.btnParciales.setOnClickListener {
            val intent = Intent(this, ParcialesActivity::class.java)
            startActivity(intent)
        }

        binding.countries.setOnClickListener {
            val intent = Intent(this, CountriesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun cargarDatosSpinnerDesdeJSON() {
        try {
            val jsonString = Miscellaneous.loadJSONFromRaw(this, R.raw.idiomas)
            if (jsonString != null) {
                val jsonArray = JSONArray(jsonString)
                val listaIdiomas = mutableListOf<String>()

                for (i in 0 until jsonArray.length()) {
                    listaIdiomas.add(jsonArray.getString(i))
                }

                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaIdiomas)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner.adapter = adapter
            } else {
                Toast.makeText(this, "No se encontró el archivo JSON", Toast.LENGTH_SHORT).show()
            }
        } catch (e: JSONException) {
            Toast.makeText(this, "Error en el formato del JSON", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

}