package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityFactorialBinding
import com.example.preparcial1.databinding.ActivityListaBinding

class FactorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFactorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFactorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        binding.enter.setOnClickListener {
            if(checkNumber(binding.numero.text.toString().toInt())) {
                var intent = Intent(baseContext, FibonacciActivity::class.java)
                intent.putExtra("numero", binding.numero.text.toString().toInt())
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "El número debe ser menor o igual a 40", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(baseContext, FactorialActivity::class.java))
            }
        }
    }
    private fun checkNumber(numero:Int): Boolean{
        if(numero>40) return false
        return true
    }
}