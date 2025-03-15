package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.preparcial1.databinding.ActivityProfesionSpinnerBinding

class ProfesionSpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

        private lateinit var binding: ActivityProfesionSpinnerBinding
        private var profesion = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityProfesionSpinnerBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val bundle = intent.getBundleExtra("paquete")
            val nombre = bundle?.getString("Nombre")
            val apellido = bundle?.getString("Apellido")
            val edad = bundle?.getInt("Edad")

            binding.textViewN.text = "Nombre: $nombre $apellido, Edad: $edad"

            val profesiones = arrayOf("Seleccione", "Ingeniero", "Doctor", "Profesor", "Abogado")
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, profesiones)
            binding.spinner.adapter = adapter
            binding.spinner.onItemSelectedListener = this

            binding.btnNext.setOnClickListener {
                if (profesion.isNotBlank() && profesion != "Seleccione") {
                    val nuevoPaquete = Bundle().apply {
                        putString("Nombre", nombre)
                        putString("Profesion", profesion)
                    }

                    val intent = Intent(this, ProfesionResultActivity::class.java).apply {
                        putExtra("paquete", nuevoPaquete)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Seleccione una profesión", Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            profesion = parent.getItemAtPosition(position).toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            // No hacer nada
        }
    }
