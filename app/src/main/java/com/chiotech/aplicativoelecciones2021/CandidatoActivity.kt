package com.chiotech.aplicativoelecciones2021

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray
import java.io.InputStream


class CandidatoActivity : AppCompatActivity() {

    var c:Candidato?=null

    var p:Partido?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidato)

        val imgCandidato = findViewById(R.id.imgCandidato) as ImageView

        val id: Int = getIntent().getIntExtra("id",-1)

        //leerJson(id+1)

        println("*******************************************D "+c?.__rowNum__)

        c=leerAssets(id+1)

        p=leerAssets2(id+1)

        println("*****************************************E "+c!!.__rowNum__)


        val url:String = "https://res.cloudinary.com/dvekizjpw/image/upload/v1611561821/partidos/"+(id+1)+".png"

        Glide.with(this).load(url).into(imgCandidato)



       // Glide.with(this).load(url).into(imgCandidato)

        // ARRGELAR TEMA CUANDO SE PASE A UN CANDIDATO SIN FOTO

        val btnCandidato=findViewById(R.id.btnCandidato) as Button
        val btnCongreso=findViewById(R.id.btnCongreso) as Button






        val txtNombre=findViewById(R.id.txtNombre) as TextView
        txtNombre.text=c?.Org_Politica

        val txtPresidente=findViewById(R.id.txtPresidente) as TextView
        val txtFundacion=findViewById(R.id.txtFundacion) as TextView
        val txtSede=findViewById(R.id.txtSede) as TextView

        txtPresidente.text="Presidente: "+p?.Presidente
        txtFundacion.text="Fundación: "+p?.Fundacion
        txtSede.text="Sede: "+p?.Sede


        /*

        val txtEdadCandidato = findViewById(R.id.txtEdadCandidato) as TextView
        val txtPrimerVice = findViewById(R.id.txtPrimerVice) as TextView
        val txtSegundoVice = findViewById(R.id.txtSegundoVice) as TextView
        val txtTiempoEnPartido = findViewById(R.id.txtTiempoEnPartido) as TextView
        val txtProfesionCandidato = findViewById(R.id.txtProfesionCandidato) as TextView
        val txtNombreCandidato = findViewById(R.id.txtNombreCandidato) as TextView
        val txtNombrePartido = findViewById(R.id.txtNombrePartido) as TextView

        txtEdadCandidato.text="Edad del Candidato: "+c?.Edad
        txtPrimerVice.text="Primer Vicepresidente: "+c?.Primer_Vicepresidente
        txtSegundoVice.text="Segundo Vicepresidente: "+c?.Segundo_Vicepresidente
        txtTiempoEnPartido.text="Tiempo del Candidato en el Partido: "+c?.TiempoAfiliacionPartidoEnROP
        txtProfesionCandidato.text="Profesión del Candidato: "+c?.Profesion
        txtNombreCandidato.text="Candidato: "+c?.Candidato
        txtNombrePartido.text="Partido: "+c?.Org_Politica

*/


        btnCandidato.setOnClickListener {


            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true) //???     MODIFICAR ESTO '?!?!?

            dialog.setContentView(R.layout.dialogo_candidato)

            val txtEdadCandidato2 = dialog.findViewById(R.id.txtEdadCandidato2) as TextView
            val txtPrimerVice2 =dialog.findViewById(R.id.txtPrimerVice2) as TextView
            val txtSegundoVice2= dialog.findViewById(R.id.txtSegundoVice2) as TextView
            val txtTiempoEnPartido2 = dialog.findViewById(R.id.txtTiempoEnPartido2) as TextView
            val txtProfesionCandidato2 = dialog.findViewById(R.id.txtProfesionCandidato2) as TextView
            val txtNombreCandidato2 = dialog.findViewById(R.id.txtNombreCandidato2) as TextView
            val txtNombrePartido2 = dialog.findViewById(R.id.txtNombrePartido2) as TextView
            val txtUltimaPostulacion2 = dialog.findViewById(R.id.txtUltimaPostulacion2) as TextView
            val txtCargos2 = dialog.findViewById(R.id.txtCargos2) as TextView
            val txtNro_partidos2 = dialog.findViewById(R.id.txtNro_partidos2) as TextView
            val imgCandidato2 = dialog.findViewById(R.id.imgCandidato2) as ImageView


            val url2:String = "https://res.cloudinary.com/dvekizjpw/image/upload/v1611961511/candidatos/"+(id+1)+".png"

            Glide.with(this).load(url2).into(imgCandidato2)


            txtEdadCandidato2.text="Edad del Candidato: "+c?.Edad
            txtPrimerVice2.text="Primer Vicepresidente: "+c?.Primer_Vicepresidente
            txtSegundoVice2.text="Segundo Vicepresidente: "+c?.Segundo_Vicepresidente
            txtTiempoEnPartido2.text="Tiempo del Candidato en el Partido: "+c?.TiempoAfiliacionPartidoEnROP
            txtProfesionCandidato2.text="Profesión del Candidato: "+c?.Profesion
            txtNombreCandidato2.text="Candidato: "+c?.Candidato
            txtNombrePartido2.text="Partido: "+c?.Org_Politica
            txtUltimaPostulacion2.text="Última Postulación: "+c?.ultima_postulacion
            txtCargos2.text="Cargos Anteriores: "+c?.CargosElectoAnterior
            txtNro_partidos2.text="Número de Partidos en los que ha Militado: "+c?.Nro_partidos


            dialog.show()
        }


        btnCongreso.setOnClickListener {

            if(id+1==10 || id+1==17 || id+1==22){
                Toast.makeText(this, "Este partido no presentó candidatos a congresista por Lima", Toast.LENGTH_SHORT).show()
            }
            else{
                val i = Intent(this,CongresistaActivity::class.java)
                i.putExtra("id",id)
                this.startActivity(i)
            }

        }


    }



    /*
    fun leerJson(id:Int):JsonObjectRequest{

        val url="https://jsonkeeper.com/b/3Y85"

        println("-----------------------------------B")

        val jsonObjectRequest= JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {
            response->

            println("-----------------------------------C")

            val array:JSONArray=response.getJSONArray("resultados")
            for(i in 0.. (array.length()-1)){
                val obj=array.getJSONObject(i)
                if(obj.getInt("__rowNum__")==id){
                    c!!.Candidato=obj.getString("Candidato")
                    c!!.Org_Politica=obj.getString("Org_Politica")
                    c!!.Primer_Vicepresidente=obj.getString("Primer_Vicepresidente")
                    c!!.Profesion=obj.getString("Profesion")
                    c!!.Segundo_Vicepresidente=obj.getString("Segundo_Vicepresidente")
                    c!!.TiempoAfiliacionPartidoEnROP=obj.getString("TiempoAfiliacionPartidoEnROP")
                    c!!.Edad=obj.getInt("Edad").toString()
                    c!!.__rowNum__=obj.getInt("__rowNum__").toString()



                }


        }}, Response.ErrorListener {
            println("---------Error")
        }
        )
        return jsonObjectRequest
        }
    */


            class Candidato(var Candidato:String,
                            var Org_Politica:String,
                            var Primer_Vicepresidente:String,
                            var Profesion:String,
                            var Segundo_Vicepresidente:String,
                            var TiempoAfiliacionPartidoEnROP:String,
                            var Edad:String,
                            var __rowNum__:String,
            var CargosElectoAnterior:String,
            var ultima_postulacion:String,
            var Nro_partidos:String)


    class Partido(var Sede:String,
    var Fundacion:String,
    var Presidente:String, var __rowNum__:String)


    fun leerAssets(cod:Int):Candidato? {

        println("****************************A "+cod)

        var can:Candidato?=null

        var json:String?=null

        val inputStream:InputStream=assets.open("candidatos.json")

        json=inputStream.bufferedReader().use { it.readText() }

        var arr=JSONArray(json)

        for(i in 0.. (arr.length()-1)){

            var obj=arr.getJSONObject(i)
            if(obj.getInt("__rowNum__")==cod){

                println("**********************************B "+obj.getString("Org_Politica"))

                can=Candidato(obj.getString("Candidato"),obj.getString("Org_Politica"),obj.getString("Primer_Vicepresidente"),obj.getString("Profesion"),obj.getString("Segundo_Vicepresidente"),obj.getString("TiempoAfiliacionPartidoEnROP"),obj.getString("Edad").toString(),obj.getInt("__rowNum__").toString(),obj.getString("CargosElectoAnterior").toString(),obj.getString("ultima_postulacion").toString(),obj.getString("Nro_partidos").toString())

              /*can?.Candidato=obj.getString("Candidato")
                can?.Org_Politica=obj.getString("Org_Politica")
                can?.Primer_Vicepresidente=obj.getString("Primer_Vicepresidente")
                can?.Profesion=obj.getString("Profesion")
                can?.Segundo_Vicepresidente=obj.getString("Segundo_Vicepresidente")
                can?.TiempoAfiliacionPartidoEnROP=obj.getString("TiempoAfiliacionPartidoEnROP")
                can?.Edad=obj.getInt("Edad").toString()
                can?.__rowNum__=obj.getInt("__rowNum__").toString() */


            }
        }

        println("****************************Z")

        return can

    }


    fun leerAssets2(cod:Int):Partido? {

        println("****************************A "+cod)

        var par:Partido?=null

        var json:String?=null

        val inputStream:InputStream=assets.open("nuevo.json")

        json=inputStream.bufferedReader().use { it.readText() }

        var arr=JSONArray(json)

        for(i in 0.. (arr.length()-1)){

            var obj=arr.getJSONObject(i)
            if(obj.getInt("__rowNum__")==cod){

                println("**********************************B "+obj.getString("Sede"))

                par=Partido(obj.getString("Sede"),obj.getString("Fundacion"),obj.getString("Presidente"),obj.getInt("__rowNum__").toString())

            }
        }

        println("****************************Z")

        return par

    }


}



