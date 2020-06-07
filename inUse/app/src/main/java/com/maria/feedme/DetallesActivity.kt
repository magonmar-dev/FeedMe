package com.maria.feedme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_detalles.*
import kotlinx.android.synthetic.main.content_detalles.*

class DetallesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
        setSupportActionBar(toolbar)

        val message1 = intent.getStringExtra(EXTRA_TITULO)
        tvTitulo.text = message1
        val message3 = intent.getStringExtra(EXTRA_CONTENIDO)
        tvContenido.text = message3
        val message4 = intent.getStringExtra(EXTRA_IMAGEN)
        Glide.with(applicationContext).load(message4).into(imageView)

        fab.setOnClickListener { view ->
            val myIntent = Intent(view.context, WebViewActivity::class.java).apply {
                putExtra(EXTRA_LINK, intent.getStringExtra(EXTRA_LINK))
            }
            startActivity(myIntent)
        }
    }
}
