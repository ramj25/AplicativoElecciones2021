package com.chiotech.aplicativoelecciones2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PartidoActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : AdaptadorPartidos = AdaptadorPartidos(getPartidos())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)
        setUpRecycler()

        // https://i.postimg.cc/dD6ddVpq/1.png

    }

    fun setUpRecycler(){
        mRecyclerView = findViewById<RecyclerView>(R.id.recPartidos)
        mRecyclerView.setHasFixedSize(true) //?
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        //    mAdapter.RecyclerAdapter(getNoticias(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getPartidos():ArrayList<Partido>{

        val a=ArrayList<Partido>()

        val lista=listOf("Acción Popular","Alianza para el Progreso","Avanza País","Democracia Directa","Frente Amplio","Frente de la Esperanza","Frepap","Fuerza Popular","Juntos por el Perú","Partido Aprista Peruano","Partido Contigo","Partido Morado","Partido Nacionalista","PPC","Partido Somos Perú","Perú Libre","Perú Nación","Perú Patria Segura","Podemos Perú","RUNA","Renovación Popular","Todos por el Perú","Unión por el Perú","Victoria Nacional")

        for(x in lista){
            var p=Partido()
            p.nombre=x
            a.add(p)
        }

        return a

    }


}