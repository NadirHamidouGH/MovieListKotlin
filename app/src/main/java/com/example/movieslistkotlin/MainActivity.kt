package com.example.movieslistkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

///
class MainActivity : AppCompatActivity() {
    var mvvm = MovieViewModel()
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
            Log.d("Err", "onCreate: $e")
        }
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.listMoviesRecyclerView)


        try {
            mvvm.extractMovies(applicationContext,  recyclerView)
        } catch (e: Exception) {
            Log.d("Extraction movies  ", "Error : $e")
        }
    }

}