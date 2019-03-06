package com.example.mymarvel.Services

import com.example.mymarvel.Models.FilmResult
import com.example.mymarvel.Models.Films
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/3/movie/{category}")
    fun getPopFilm(
            @Path("category") category : String,
            @Query("api_key") apiKey : String,
            @Query("language") language : String,
            @Query("page") page : Int
    ) : Call<FilmResult>

    @GET("/3/movie/{movie_id}")
    fun getDetailFilm(
            @Path("movie_id") movieId : String,
            @Query("api_key") apiKey : String,
            @Query("language") language : String
    ) : Call<FilmResult>
}