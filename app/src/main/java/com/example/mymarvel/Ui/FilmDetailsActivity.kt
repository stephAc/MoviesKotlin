package com.example.mymarvel.Ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.mymarvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_film_details_activity.*
import com.example.mymarvel.MainActivity
import android.content.Intent
import android.view.View


class FilmDetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_details_activity)
        val bundle = intent.extras
        val posterPath = bundle?.getString("filmPosterPath").toString()
        val txtOverviewDetail = findViewById<TextView>(R.id.txtOverviewDetail)
        val txtTitleDetail = findViewById<TextView>(R.id.txtTitleDetail)
        val imgPoster = findViewById<ImageView>(R.id.imgPosterDetail)
        val txtDate = findViewById<TextView>(R.id.txtDateDetail)

        toolbarTitleDetail.setNavigationIcon(R.drawable.baseline_arrow_back_black_24dp)
        txtDate.text = bundle.getString("filmDate").toString()
        txtTitleDetail.text = bundle.getString("filmTitle").toString()
        txtOverviewDetail.text = bundle.getString("filmOverview").toString()
        Picasso.get().load("https://image.tmdb.org/t/p/w780/${posterPath}").into(imgPoster)

        toolbarTitleDetail.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        })
    }
}