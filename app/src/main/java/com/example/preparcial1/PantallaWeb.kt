package com.example.preparcial1

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.preparcial1.databinding.ActivityWebBinding

class PantallaWeb : AppCompatActivity() {

    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inicializar el binding
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //cargar la pagina web
        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl("https://www.javeriana.edu.co/inicio")


    }

}