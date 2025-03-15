package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preparcial1.databinding.ActivityIntentsBinding


class IntentsActivity : AppCompatActivity() {
        private lateinit var binding: ActivityIntentsBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityIntentsBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnNext.setOnClickListener {
                val nombre = binding.NombreTxt.text.toString()
                val apellido = binding.EdadTxt.text.toString()
                val edadText = binding.PesoTxt.text.toString()

                if (nombre.isBlank() || apellido.isBlank() || edadText.isBlank()) {
                    Toast.makeText(this, "Por favor ingrese todos los datos", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val paquete = Bundle().apply {
                    putString("Nombre", nombre)
                    putString("Apellido", apellido)
                    putInt("Edad", edadText.toInt())
                }

                val intent = Intent(this, ProfesionSpinnerActivity::class.java).apply {
                    putExtra("paquete", paquete)
                }
                startActivity(intent)
            }

            binding.btnWeb.setOnClickListener {
                startActivity(Intent(this, PantallaWeb::class.java))
            }
        }
    }