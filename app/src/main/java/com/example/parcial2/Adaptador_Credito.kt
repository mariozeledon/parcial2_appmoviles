package com.example.parcial2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adaptador_Credito(val credito : List<Datos>) : RecyclerView.Adapter<Adaptador_Credito.Adaptador>() {
    class Adaptador(val view: View) : RecyclerView.ViewHolder(view) {
        val tvUniversidad: TextView = view.findViewById(R.id.tvUniversidad)
        val tvCarnet: TextView = view.findViewById(R.id.tvCarnet)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val ivCredito: ImageView = view.findViewById(R.id.ivCreditos)

        fun cargarDatos(credito: Datos) {
            tvUniversidad.text = credito.universidad
            tvNombre.text = credito.nombre
            tvCarnet.text = credito.carne
            Picasso.get().load(credito.imagen).into(ivCredito)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador {
        val layoutInflater = LayoutInflater.from(parent.context)
        return Adaptador(layoutInflater.inflate(R.layout.cardview_creditos, parent, false))

    }

    override fun onBindViewHolder(holder: Adaptador, position: Int) {
        holder.cargarDatos(credito[position])
    }

    override fun getItemCount(): Int = credito.size
}



/*class AdaptadorProducto (val producto : List<Producto>) : RecyclerView.Adapter<AdaptadorProducto.AdaptadorPersonalizadoProducto>(){
    class AdaptadorPersonalizadoProducto(val viewP : View) : RecyclerView.ViewHolder(viewP){
        val tvCodigo : TextView = viewP.findViewById(R.id.tvCodigoP)
        val tvNombre : TextView = viewP.findViewById(R.id.tvNombreP)
        val tvPrecio : TextView = viewP.findViewById(R.id.tvPrecioP)
        val imProducto : ImageView = viewP.findViewById(R.id.imProdutos)

        fun cargarProducto(producto:Producto){
            tvCodigo.text = producto.codigo
            tvNombre.text = producto.nombre
            tvPrecio.text = producto.precio
            Picasso.get().load(producto.imagen).into(imProducto)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorPersonalizadoProducto {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AdaptadorPersonalizadoProducto(layoutInflater.inflate(R.layout.carview_producto,parent,false))
    }

    override fun onBindViewHolder(holder: AdaptadorPersonalizadoProducto, position: Int) {
        holder.cargarProducto(producto[position])
    }

    override fun getItemCount(): Int = producto.size
}*/