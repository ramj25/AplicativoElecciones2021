package com.chiotech.aplicativoelecciones2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONArray
import java.io.InputStream

class CongresistaActivity : AppCompatActivity() {

    lateinit var mRecycler: RecyclerView
    lateinit var mAdapter : AdaptadorCongresistas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congresista)

        val id: Int = getIntent().getIntExtra("id",-1)

        mAdapter=AdaptadorCongresistas(leerAssets3(id+1))

        val imgGif=findViewById(R.id.imgGif) as ImageView

        Glide.with(this)
            .load(R.drawable.backfnd)
            .into(imgGif)


        Toast.makeText(this, "Candidatos a congresista por Lima - Presione uno para ver detalles (Profesión y edad)", Toast.LENGTH_SHORT).show()


        //println("*******************************************W "+id)


            mRecycler = findViewById<RecyclerView>(R.id.recCongresista)
            mRecycler.setHasFixedSize(true) //?
            mRecycler.layoutManager = LinearLayoutManager(this)
            //    mAdapter.RecyclerAdapter(getNoticias(), this)
            mRecycler.adapter = mAdapter



    }


    fun leerAssets3(cod:Int): ArrayList<Congresista> {

        println("****************************A ")

        var lc: ArrayList<Congresista>?=ArrayList<Congresista>()

        var json:String?=null

        val inputStream: InputStream =assets.open("congresistas.json")

        json=inputStream.bufferedReader().use { it.readText() }

        var arr= JSONArray(json)

        for(i in 0.. (arr.length()-1)){

            var obj=arr.getJSONObject(i)

            println("****************************B ")

            if(obj.getInt("__rowNum__")==cod){

                println("****************************C ")

                for(j in 0.. (obj.getJSONArray("con")).length()-1){

                    println("****************************D ")

                    var obj2=obj.getJSONArray("con").getJSONObject(j)

                    var con=Congresista()
                    con.id=obj2.getInt("id").toString()
                    con.nombre=obj2.getString("nombre")
                    con.profesion=obj2.getString("prof")
                    con.edad=obj2.getString("edad")

                    lc?.add(con)
                }
            }
        }
        //println("****************************Z")
        return lc!!
    }



}