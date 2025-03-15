package com.example.preparcial1

data class Country(val nombrePais: String, val capital: String, val sigla: String) {
    val flagUrl: String
        get() = "https://flagcdn.com/w320/${sigla.lowercase()}.png"
}


