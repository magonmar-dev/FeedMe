package com.maria.feedme

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maria.feedme.model.Noticia

const val EXTRA_TITULO = "miTitulo"
const val EXTRA_CONTENIDO = "miContenido"
const val EXTRA_IMAGEN = "miImagen"
const val EXTRA_LINK = "miLink"

class RecyclerAdapter(var listaNoticias: ArrayList<Noticia>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binItems(listaNoticias[position])
    }

    override fun getItemCount(): Int {
        return listaNoticias.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binItems(datos: Noticia) {
            val titulo: TextView = itemView.findViewById(R.id.tvTitle)
            val fecha: TextView = itemView.findViewById(R.id.tvFecha)
            val imagen: ImageView = itemView.findViewById(R.id.imageView)

            if(datos.titulo.length > 100)
                titulo.text = datos.titulo.substring(0,100) + "..."
            else
                titulo.text = datos.titulo
            fecha.text = datos.fechaPub

            Glide.with(itemView.context).load(datos.miniatura).into(imagen)

            val card: CardView = itemView.findViewById(R.id.cardView)
            card.setOnClickListener {
                val myIntent = Intent(itemView.context, DetallesActivity::class.java).apply {
                    putExtra(EXTRA_TITULO, datos.titulo)
                    putExtra(EXTRA_CONTENIDO, datos.contenido)
                    putExtra(EXTRA_IMAGEN, datos.imagen)
                    putExtra(EXTRA_LINK, datos.link)
                }
                itemView.context.startActivity(myIntent)
            }
        }
    }
}
