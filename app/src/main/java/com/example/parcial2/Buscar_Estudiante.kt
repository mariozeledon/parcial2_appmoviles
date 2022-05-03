package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Buscar_Estudiante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_estudiante)

        val etCarne = findViewById<EditText>(R.id.etCarne_buscar)
        val etNombre = findViewById<EditText>(R.id.etNombre_buscar)
        val etApellido = findViewById<EditText>(R.id.etApellido_buscar)
        val etDireccion = findViewById<EditText>(R.id.etDireccion_buscar)
        val etTelefono = findViewById<EditText>(R.id.etTelefono_buscar)
        val etCorreo = findViewById<EditText>(R.id.etCorreo_buscar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar_buscar)
        val btnActualizar = findViewById<Button>(R.id.btnActializar_buscar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar_buscar)
        val btnInicio = findViewById<Button>(R.id.btnRegresar_buscar)

        btnBuscar.setOnClickListener {
            val respuesta = Volley.newRequestQueue(this)

            var url = "https://201805909actividad3.000webhostapp.com/parcial2_appmovil/buscarEstudiante.php?"
            url +="carne_alumno="+etCarne.getText().toString()

            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    val jsonArray = JSONArray(response)
                    var objetoJson = JSONObject(jsonArray.getString(0))

                    etNombre.setText(objetoJson.getString("nombre"))
                    etApellido.setText(objetoJson.getString("apellido"))
                    etDireccion.setText(objetoJson.getString("direccion"))
                    etTelefono.setText(objetoJson.getString("telefono"))
                    etCorreo.setText(objetoJson.getString("email"))
                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this,"Error en el servicio web", Toast.LENGTH_SHORT).show()

                })
            respuesta.add(stringRequest)
        }

        btnActualizar.setOnClickListener {
            val respuesta = Volley.newRequestQueue(this)

            var url = "https://201805909actividad3.000webhostapp.com/parcial2_appmovil/actualizarEstudiante.php?"
            url +="carne_alumno="+etCarne.getText().toString()
            url +="&nombre="+ etNombre.getText().toString()
            url +="&apellido="+ etApellido.getText().toString()
            url +="&direccion="+ etDireccion.getText().toString()
            url +="&telefono="+ etTelefono.getText().toString()
            url +="&email="+ etCorreo.getText().toString()

            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    val jsonArray = JSONArray(response)
                    var objetoJson = JSONObject(jsonArray.getString(0))

                    Toast.makeText(this,"Datos actualizados", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this,"Error en el servicio web", Toast.LENGTH_SHORT).show()
                })

            // Add the request to the RequestQueue.
            respuesta.add(stringRequest)
        }

        btnEliminar.setOnClickListener {
            val respuesta = Volley.newRequestQueue(this)

            var url = "https://201805909actividad3.000webhostapp.com/parcial2_appmovil/eliminarEstudiante.php?carne_alumno=" + etCarne.getText().toString()

            // Formulate the request and handle the response.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    Toast.makeText(this,"Registro Eliminado", Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this,"Error al Eliminar", Toast.LENGTH_SHORT).show()

                })

            // Add the request to the RequestQueue.
            respuesta.add(stringRequest)
        }

        btnInicio.setOnClickListener {
            Toast.makeText(this, "Menu",Toast.LENGTH_LONG).show()
            val inicio : Intent = Intent(this, MainActivity::class.java)
            startActivity(inicio)
        }
    }
}