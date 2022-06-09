package com.chiotech.aplicativoelecciones2021

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdaptadorCongresistas (private val dataSet: ArrayList<Congresista>) :
    RecyclerView.Adapter<AdaptadorCongresistas.ViewHolder>() {

    val congresistas=dataSet



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtNombreCon: TextView
        val imgNumeroCon: ImageView
        val txtProfesionCon: TextView
        val txtEdadCon: TextView
        val llCon: LinearLayout


        init {
            // Define click listener for the ViewHolder's View.
            txtNombreCon = view.findViewById(R.id.txtNombreCon)
            imgNumeroCon = view.findViewById(R.id.imgNumeroCon)
            txtProfesionCon = view.findViewById(R.id.txtProfesionCon)
            txtEdadCon = view.findViewById(R.id.txtEdadCon)
            llCon = view.findViewById(R.id.llCon)



            view.setOnClickListener {

                if(llCon.visibility==View.GONE){
                    llCon.visibility=View.VISIBLE
                }
                else{
                    llCon.visibility=View.GONE
                }

            }

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fila_congresista, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.textView.text = dataSet[position]

        var c= congresistas.get(position)

        viewHolder.txtNombreCon.setText(c.nombre)
        viewHolder.txtEdadCon.setText(c.edad)
        viewHolder.txtProfesionCon.setText(c.profesion+",")


/*
        Glide.with(viewHolder.itemView.context)
            .load(viewHolder.itemView.context.getResources().
                getIdentifier("g"+(position+1).toString()+".png", "drawable", viewHolder.itemView.context.getPackageName()))
                .into(viewHolder.imgNumeroCon)
*/

        val url3:String = "https://res.cloudinary.com/dvekizjpw/image/upload/v1613051750/candidatos/numeros/"+(position+1)+".png"

        Glide.with(viewHolder.itemView.context).load(url3).into(viewHolder.imgNumeroCon)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}






