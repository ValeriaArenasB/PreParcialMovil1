package com.example.preparcial1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityRandomGreetBinding
import org.json.JSONArray
import org.json.JSONException
import kotlin.random.Random

class RandomGreetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomGreetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomGreetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Traer el string enviado por intent en MainActivity y guardarlo en idioma
        val idioma = intent.getStringExtra("seleccion")

        idioma?.let {
            val saludo = saludoAleatorio(it)
            binding.tvGreeting.text = saludo
        } ?: run {
            binding.tvGreeting.text = "Idioma no reconocido."
        }

        binding.btnVolver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun saludoAleatorio(idioma: String): String {
        val jsonString = Miscellaneous.loadJSONFromRaw(this, R.raw.saludos)
        return try {
            val jsonObject = JSONArray(jsonString)
            val saludos = mutableListOf<String>()
            for (i in 0 until jsonObject.length()) {
                val obj = jsonObject.getJSONObject(i)
                if (obj.getString("idioma") == idioma) {
                    val listaSaludos = obj.getJSONArray("saludos")
                    for (j in 0 until listaSaludos.length()) {
                        saludos.add(listaSaludos.getString(j))
                    }
                }
            }
            if (saludos.isNotEmpty()) saludos[Random.nextInt(saludos.size)] else "¡Hola Usuario!"
        } catch (e: JSONException) {
            e.printStackTrace()
            "¡Hola Usuario!"
        }
    }
}


