package com.chiotech.aplicativoelecciones2021

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessController.getContext
import com.bumptech.glide.*
import com.bumptech.glide.Glide

class AdaptadorPartidos (private val dataSet: ArrayList<Partido>) :
        RecyclerView.Adapter<AdaptadorPartidos.ViewHolder>() {

    val partidos=dataSet

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtNombre: TextView
        val imgLogo: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            txtNombre = view.findViewById(R.id.txtNombre)
            imgLogo = view.findViewById(R.id.imgLogo)



            view.setOnClickListener {

                val i = Intent(view.context,CandidatoActivity::class.java)
                i.putExtra("id",position)
                view.context.startActivity(i)


            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.fila_partidos, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.textView.text = dataSet[position]

        var naa= partidos.get(position)
        viewHolder.txtNombre.setText(naa.nombre)

        val url:String = "https://res.cloudinary.com/dvekizjpw/image/upload/v1611561821/partidos/"+(position+1)+".png"

        Glide.with(viewHolder.itemView.context).load(url).into(viewHolder.imgLogo)


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}




