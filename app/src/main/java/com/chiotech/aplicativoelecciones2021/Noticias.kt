package com.chiotech.aplicativoelecciones2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Noticias : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : AdaptadorNoticias = AdaptadorNoticias(getNoticias())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)
        setUpRecyclerView()

    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById<RecyclerView>(R.id.recNoticias)
        mRecyclerView.setHasFixedSize(true) //?
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        //    mAdapter.RecyclerAdapter(getNoticias(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun getNoticias():ArrayList<Noticia>{
        var arreglo=ArrayList<Noticia>()
        var not1=Noticia()
        not1.titulo="15/01/21 ONPE publica diseño definitivo de la cédula de sufragio para las Elecciones 2021"
        not1.enlace="https://gestion.pe/peru/politica/conoce-la-cedula-de-sufragio-onpe-publica-diseno-definitivo-para-las-elecciones-2021-nndc-noticia/"
        arreglo.add(not1)
        var not2=Noticia()
        not2.titulo="17/01/21 JNE: cómo saber si tengo multas electorales pendientes de pago"
        not2.enlace="https://gestion.pe/peru/jne-como-saber-si-tengo-multas-electorales-pendientes-de-pago-nnda-nnlt-noticia/"
        arreglo.add(not2)
        var not3=Noticia()
        not3.titulo="19/01/21 Partidos políticos ratifican compromisos del Pacto Ético Electoral del JNE"
        not3.enlace="https://elperuano.pe/noticia/113857-partidos-politicos-ratifican-compromisos-del-pacto-etico-electoral-del-jne"
        arreglo.add(not3)
        var not4=Noticia()
        not4.titulo="21/01/21 Elecciones 2021: ONPE designó por sorteo a más de 518,000 miembros de mesa"
        not4.enlace="https://elperuano.pe/noticia/114338-elecciones-2021-onpe-designo-por-sorteo-mas-de-518000-miembros-de-mesa"
        arreglo.add(not4)
        var not5=Noticia()
        not5.titulo="23/01/21 Elecciones 2021: ONPE designó por sorteo a más de 518,000 miembros de mesa"
        not5.enlace="https://gestion.pe/peru/politica/elecciones-2021-17-partidos-politicos-suscriben-pacto-etico-electoral-nndc-noticia/"
        arreglo.add(not5)
        var not6=Noticia()
        not6.titulo="24/01/21 Elecciones 2021: Estos son los horarios en los que se recomienda ir a votar según tu número de DNI"
        not6.enlace="https://peru.as.com/peru/2021/01/05/actualidad/1609861987_067141.html"
        arreglo.add(not6)
        var not7=Noticia()
        not7.titulo="27/01/21 Perfil electoral: ¿Qué partidos políticos llevan a más jóvenes y mujeres en sus filas?"
        not7.enlace="https://gestion.pe/peru/politica/perfil-electoral-que-partidos-politicos-llevan-a-mas-jovenes-y-mujeres-en-sus-filas-nczg-noticia/"
        arreglo.add(not7)
        var not8=Noticia()
        not8.titulo="29/01/21 JNE aprueba cronograma electoral para revocatoria del 10 de octubre de 2021"
        not8.enlace="https://elperuano.pe/noticia/113532-jne-aprueba-cronograma-electoral-para-revocatoria-del-10-de-octubre-de-2021"
        arreglo.add(not8)
        var not9=Noticia()
        not9.titulo="01/02/21 Elecciones 2021: Los rostros técnicos de esta campaña electoral"
        not9.enlace="https://elcomercio.pe/elecciones-2021/elecciones-2021-los-rostros-tecnicos-de-esta-campana-electoral-especial-victoria-nacional-app-partido-morado-juntos-por-el-peru-fuerza-popular-podemos-peru-noticia/"
        arreglo.add(not9)
        var not10=Noticia()
        not10.titulo="02/02/21 JNE apuesta por ejecución del cronograma electoral"
        not10.enlace="https://elperuano.pe/noticia/114521-jne-apuesta-por-ejecucion-del-cronograma-electoral"
        arreglo.add(not10)
        var not11=Noticia()
        not11.titulo="02/02/21 El Peruano y Andina empiezan hoy un ciclo de entrevistas a los candidatos presidenciales"
        not11.enlace="https://elperuano.pe/noticia/114546-el-peruano-y-andina-empiezan-hoy-un-ciclo-de-entrevistas-a-los-candidatos-presidenciales"
        arreglo.add(not11)
        var not12=Noticia()
        not12.titulo="02/02/21 Más de 20,000 peruanos participarán como miembros de mesa en el extranjero"
        not12.enlace="https://andina.pe/agencia/noticia-mas-20000-peruanos-participaran-como-miembros-mesa-el-extranjero-832261.aspx"
        arreglo.add(not12)

        return arreglo

    }


}