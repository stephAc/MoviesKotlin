package com.example.mymarvel.Utilities

import android.util.Log
import com.example.mymarvel.MainActivity.url.API_KEY
import com.example.mymarvel.MainActivity.url.BASE_URL
import com.example.mymarvel.MainActivity.url.CATEGORY
import com.example.mymarvel.MainActivity.url.LANGUAGE
import com.example.mymarvel.MainActivity.url.PAGE
import com.example.mymarvel.Models.FilmResult
import com.example.mymarvel.Models.Films
import com.example.mymarvel.Services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFilm {
    companion object ApiFilm {
        fun createApiService() {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val myInterface = retrofit.create(ApiInterface::class.java)
            val call = myInterface.getPopFilm(CATEGORY, API_KEY, LANGUAGE, PAGE)
            call.enqueue(object : Callback<FilmResult> {
                override fun onFailure(call: Call<FilmResult>, t: Throwable) {
                    println("Error on response")
                }

                override fun onResponse(call: Call<FilmResult>, response: Response<FilmResult>) {
                    val result = response.body()
                    val listFilmPop = result?.results

                    Log.d("§","" + listFilmPop?.get(0))
                    println(listFilmPop)
                }
            })
        }
    }
}