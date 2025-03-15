package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityFactorialBinding
import com.example.preparcial1.databinding.ActivityFibonacciBinding
import java.sql.Array

class FibonacciActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFibonacciBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFibonacciBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val numFibonacci = intent.getIntExtra("numero",0)

        var arregloFibonacci = Array(numFibonacci){index->fibonacci(index)}

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,arregloFibonacci)
        binding.listaFibonacci.adapter = adapter
        binding.numeroMayor.text = arregloFibonacci.last().toString()

    }

    private fun fibonacci(index: Int): Int{
        if(index == 0 || index == 1){
            return index
        }else{
            return fibonacci(index-1) + fibonacci(index-2)
        }

    }
}