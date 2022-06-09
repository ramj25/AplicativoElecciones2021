package com.chiotech.aplicativoelecciones2021

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AdaptadorNoticias(private val dataSet: ArrayList<Noticia>) :
        RecyclerView.Adapter<AdaptadorNoticias.ViewHolder>() {


    val noticias =dataSet

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtTitulo:TextView
        val txtEnlace:TextView

        init {
            // Define click listener for the ViewHolder's View.
            txtTitulo = view.findViewById(R.id.txtTitulo)
            txtEnlace= view.findViewById(R.id.txtEnlace)


            view.setOnClickListener {

                val i = Intent(Intent.ACTION_VIEW, Uri.parse(txtEnlace.text as String))
                view.context.startActivity(i)

            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.fila_noticias, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.textView.text = dataSet[position]

        val n=noticias.get(position)
        viewHolder.txtTitulo.setText(n.titulo)
        viewHolder.txtEnlace.setText(n.enlace)


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
