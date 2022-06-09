package com.chiotech.aplicativoelecciones2021

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val fecha = "2021-04-11 08:00:00"
    private val formato = "yyyy-MM-dd HH:mm:ss"
    lateinit var runnable:Runnable
    var handler= Handler()
    lateinit var dias: TextView
    lateinit var horas: TextView
    lateinit var minutos: TextView
    lateinit var segundos: TextView

  //  lateinit var ll1: LinearLayout
  //  lateinit var ll2: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnShare=findViewById(R.id.btnShare) as Button
        val btnComenzar=findViewById(R.id.btnComenzar) as Button

        val btnWiki=findViewById(R.id.btnWiki) as Button
        val btnTime=findViewById(R.id.btnTime) as Button
        val btnOnpe=findViewById(R.id.btnOnpe) as Button

        val timer=findViewById(R.id.timer) as LinearLayout

        dias=findViewById(R.id.Dias) as TextView
        horas=findViewById(R.id.Horas) as TextView
        minutos=findViewById(R.id.Minutos) as TextView
        segundos=findViewById(R.id.Segundos) as TextView

      //  ll1=findViewById(R.id.linear_layout_1) as LinearLayout
      //  ll2=findViewById(R.id.linear_layout_2) as LinearLayout

        timer()


        btnShare.setOnClickListener{
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Mantente actualizado con la última información sobre las elecciones de este 2021 con esta aplicación:")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Compartir por:"))

    }

        btnComenzar.setOnClickListener{

            val intent= Intent(this,Menu::class.java)
            this.startActivity(intent)

        }

        btnWiki.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://es.wikipedia.org/wiki/Elecciones_generales_de_Per%C3%BA_de_2021"))
            this.startActivity(i)
        }

        btnOnpe.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.onpe.gob.pe/modElecciones/elecciones/2021/EEGG/"))
            this.startActivity(i)
        }

        btnTime.setOnClickListener {

            if(timer.visibility!= View.VISIBLE){
                timer.visibility=View.VISIBLE
            }
            else{
                timer.visibility=View.INVISIBLE
            }

        }
}

    fun timer(){
        runnable = object : Runnable {
            override fun run() {
                try {
                    handler.postDelayed(this, 1000)
                    val dateFormat = SimpleDateFormat(formato)
                    val event_date = dateFormat.parse(fecha)
                    val current_date = Date()
                    if (!current_date.after(event_date)) {
                        val diff = event_date.time - current_date.time
                        val Days = diff / (24 * 60 * 60 * 1000)
                        val Hours = diff / (60 * 60 * 1000) % 24
                        val Minutes = diff / (60 * 1000) % 60
                        val Seconds = diff / 1000 % 60
                        //
                        dias.setText(String.format("%02d", Days))
                        horas.setText(String.format("%02d", Hours))
                        minutos.setText(String.format("%02d", Minutes))
                        segundos.setText(String.format("%02d", Seconds))
                    } //else {
                     //   ll1.setVisibility(View.VISIBLE)
                     //   ll2.setVisibility(View.GONE)
                     //   handler.removeCallbacks(runnable)
                   // }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        handler.postDelayed(runnable, 0)
    }


}
