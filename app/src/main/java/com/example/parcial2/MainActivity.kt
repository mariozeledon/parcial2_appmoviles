package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInsertar = findViewById<Button>(R.id.btnAgregar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnCreditos = findViewById<Button>(R.id.btnCreditos)

        btnInsertar.setOnClickListener {
            Toast.makeText(this, "Agregar nuevo estudiante", Toast.LENGTH_LONG).show()
            val insertar : Intent = Intent(this, Insertar_Estudiante::class.java)
            startActivity(insertar)
        }

        btnBuscar.setOnClickListener {
            Toast.makeText(this, "Buscar estudiante, puede modificar y eliminar", Toast.LENGTH_LONG).show()
            val buscar : Intent = Intent(this, Buscar_Estudiante::class.java)
            startActivity(buscar)
        }

        btnCreditos.setOnClickListener {
            Toast.makeText(this, "Creador de la aplicación",Toast.LENGTH_LONG).show()
            val creditos : Intent = Intent(this, Creditos::class.java)
            startActivity(creditos)
        }
    }
}