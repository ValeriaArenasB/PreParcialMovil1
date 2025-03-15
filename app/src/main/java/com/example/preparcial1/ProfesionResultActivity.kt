package com.example.preparcial1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preparcial1.databinding.ActivityProfesionResultBinding

class ProfesionResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfesionResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfesionResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("paquete")
        val nombre = bundle?.getString("Nombre")
        val profesion = bundle?.getString("Profesion")

        binding.textView3.text = "Nombre: $nombre\nProfesión: $profesion"
    }
}