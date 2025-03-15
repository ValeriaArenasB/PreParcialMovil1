package com.example.preparcial1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preparcial1.databinding.ActivityAdivinadorBinding
import kotlin.random.Random

class AdivinadorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdivinadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdivinadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        adivinar()

    }
    private fun adivinar() {
        var randonNumber = Random.nextInt(1, 101)
        var atemps = 0
        binding.button.setOnClickListener {
            atemps++
            val numeroIngresado = binding.numeroIngresado.text.toString()
            if (numeroIngresado == randonNumber.toString()) {
                binding.salidaTexto.setText("correcto!")
                binding.numeroIngresado.isEnabled = false
            } else if(numeroIngresado.toInt() < randonNumber){
                binding.salidaTexto.setText("El numero es mayor")
            } else {
                binding.salidaTexto.setText("El numero es menor")
            }
            binding.intetos.setText(atemps.toString())

        }
    }

}