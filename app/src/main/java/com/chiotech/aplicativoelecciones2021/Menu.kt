package com.chiotech.aplicativoelecciones2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnCandidatos=findViewById<Button>(R.id.btnCandidatos)
        val btnNoticias=findViewById<Button>(R.id.btnNoticias)


        btnNoticias.setOnClickListener {
            val intent= Intent(this, Noticias::class.java)
            startActivity(intent)
        }

        btnCandidatos.setOnClickListener {
            val intent= Intent(this, PartidoActivity::class.java)
            startActivity(intent)
        }

    }
}