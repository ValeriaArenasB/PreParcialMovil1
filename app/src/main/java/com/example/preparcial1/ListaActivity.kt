package com.example.preparcial1

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        var numero = intent.getIntExtra("numero", 0)
        val factorial = Array(numero) { index -> (index+1).toString() }
        var reverse = factorial.reversedArray()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, reverse)
        binding.listView.adapter = adapter
    }
}