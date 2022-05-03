package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Insertar_Estudiante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_estudiante)

        val etCarne = findViewById<EditText>(R.id.etCarne_insertar)
        val etNombre = findViewById<EditText>(R.id.etNombre_insertar)
        val etApellido = findViewById<EditText>(R.id.etApellido_insertar)
        val etDireccion = findViewById<EditText>(R.id.etDireccion_insertar)
        val etTelefono = findViewById<EditText>(R.id.etTelefono_insertar)
        val etCorreo = findViewById<EditText>(R.id.etEmail_insertar)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar_insertar)
        val btnInicio = findViewById<Button>(R.id.btnRegresar_insertar)

        btnGuardar.setOnClickListener {
            val respuesta = Volley.newRequestQueue(this);

            var url = "https://201805909actividad3.000webhostapp.com/parcial2_appmovil/insertarEstudiante.php?"
            url += "carne_alumno=" + etCarne.getText().toString()
            url += "&nombre=" + etNombre.getText().toString()
            url += "&apellido=" + etApellido.getText().toString()
            url += "&direccion=" + etDireccion.getText().toString()
            url += "&telefono=" + etTelefono.getText().toString()
            url += "&email=" + etCorreo.getText().toString()

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    val jsonArray = JSONArray(response)
                    val objeto = JSONObject(jsonArray.getString(0))

                    Log.d("Datos", objeto.toString())
                    Log.d("Carne: ", objeto.getString("carne_alumno"))
                    Log.d("Nombre: ", objeto.getString("nombre"))
                    Log.d("Apellido: ", objeto.getString("apellido"))

                    //Toast.makeText(this, vehiculo.id.toString(), Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Elemento insertado", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this, "Error al insertar", Toast.LENGTH_LONG).show()
                })
            respuesta.add(stringRequest)
        }

        btnInicio.setOnClickListener {
            Toast.makeText(this, "Menú", Toast.LENGTH_LONG).show()
            val inicio : Intent = Intent(this, MainActivity::class.java)
            startActivity(inicio)
        }
    }
}