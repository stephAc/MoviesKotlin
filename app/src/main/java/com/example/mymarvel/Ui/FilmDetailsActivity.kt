package com.example.mymarvel.Ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.mymarvel.MainActivity
import com.example.mymarvel.Models.FilmResult
import com.example.mymarvel.R
import com.example.mymarvel.Services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmDetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_details_activity)
        val bundle = intent.extras

        val retrofit = Retrofit.Builder()
            .baseUrl(MainActivity.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Log.d("§", "" + bundle?.getInt("filmId").toString())

        val myInterface = retrofit.create(ApiInterface::class.java)
        val call = myInterface.getDetailFilm(
            bundle?.getInt("filmId").toString(),
            MainActivity.API_KEY,
            MainActivity.LANGUAGE
        )

        call.enqueue(object : Callback<FilmResult> {
            override fun onFailure(call: Call<FilmResult>, t: Throwable) {
                println("Error on response")
            }

            override fun onResponse(call: Call<FilmResult>, response: Response<FilmResult>) {
                val result = response.body()
                val listFilmPop = result!!.results

                Log.d("§","" + result)
                Log.d("§","" + listFilmPop)
            }
        })
    }
}