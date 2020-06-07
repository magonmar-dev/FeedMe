package com.maria.feedme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maria.feedme.model.Noticia
import com.maria.feedme.utils.NoticiasUtils

class MainActivity : AppCompatActivity() {

    companion object{
        var noticias: ArrayList<Noticia> = ArrayList()
        var enlacesMarca: Array<String> = arrayOf("https://e00-marca.uecdn.es/rss/futbol/primera-division.xml",
            "https://e00-marca.uecdn.es/rss/futbol/segunda-division.xml",
            "https://e00-marca.uecdn.es/rss/futbol/mas-futbol.xml",
            "https://e00-marca.uecdn.es/rss/futbol/copa-rey.xml",
            "https://e00-marca.uecdn.es/rss/futbol/futbol-femenino.xml",
            "https://e00-marca.uecdn.es/rss/futbol/seleccion.xml",
            "https://e00-marca.uecdn.es/rss/futbol/futbol-sala.xml",
            "https://e00-marca.uecdn.es/rss/futbol/futbol-internacional.xml",
            "https://e00-marca.uecdn.es/rss/futbol/champions-league.xml",
            "https://e00-marca.uecdn.es/rss/futbol/europa-league.xml",
            "https://e00-marca.uecdn.es/rss/futbol/premier-league.xml",
            "https://e00-marca.uecdn.es/rss/futbol/bundesliga.xml",
            "https://e00-marca.uecdn.es/rss/futbol/mundial-de-clubes.xml",
            "https://e00-marca.uecdn.es/rss/futbol/america.xml")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until enlacesMarca.size) {
            noticias.addAll(NoticiasUtils(enlacesMarca[i]).execute().get())
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        var adapter = RecyclerAdapter(noticias)
        recyclerView.adapter = adapter
    }
}