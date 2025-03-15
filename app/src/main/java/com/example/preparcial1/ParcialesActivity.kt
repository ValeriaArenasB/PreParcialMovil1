package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preparcial1.databinding.ActivityParcialesBinding

class ParcialesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParcialesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParcialesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fatorial.setOnClickListener {
            startActivity(Intent(baseContext, FactorialActivity::class.java))
        }
        binding.adivinar.setOnClickListener {
            startActivity(Intent(baseContext, AdivinadorActivity::class.java))
        }

    }
}