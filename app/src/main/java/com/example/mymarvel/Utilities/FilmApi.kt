package com.example.mymarvel.Utilities

import com.example.mymarvel.Data.FilmCollection
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import org.json.JSONObject



fun getFilmPopular()  {

       val url = "https://api.themoviedb.org/3/movie/popular?api_key=22232165bd2420fd47b1eb7520ab231c&page=1"
       val client = OkHttpClient();
       val req = Request.Builder().url(url).build()

       client.newCall(req).enqueue(object : Callback {
           override fun onResponse(call: Call?, response: Response?) {
               val body = response?.body()?.string();
               println("body: ${body}")

               val Jobject = JSONObject(body)
               println("Jobject: ${Jobject}")
               val Jarray  = Jobject.getJSONArray("results")
               println("Jarray: ${Jarray}")


               /*
               val gson = GsonBuilder().create()
               //FilmCollection::class.java Pour en faire un type
               val filmCollection = gson.toJson(Jarray, FilmCollection::class.java)
               println(filmCollection)*/
           }

           override fun onFailure(call: Call, e: IOException) {
               println("failure on request")
           }
       })
}