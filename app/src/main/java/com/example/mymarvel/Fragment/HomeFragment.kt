package com.example.mymarvel.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymarvel.Adapter.GridHomeAdapter
import com.example.mymarvel.MainActivity
import com.example.mymarvel.Models.FilmResult
import com.example.mymarvel.R
import com.example.mymarvel.Services.ApiInterface
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var gridHomeAdapter: GridHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl(MainActivity.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myInterface = retrofit.create(ApiInterface::class.java)
        val call = myInterface.getPopFilm(
            MainActivity.CATEGORY,
            MainActivity.API_KEY,
            MainActivity.LANGUAGE,
            MainActivity.PAGE
        )
        call.enqueue(object : Callback<FilmResult> {
            override fun onFailure(call: Call<FilmResult>, t: Throwable) {
                println("Error on response")
            }

            override fun onResponse(call: Call<FilmResult>, response: Response<FilmResult>) {
                val result = response.body()
                val listFilmPop = result!!.results

                Log.d("§","" + listFilmPop.get(0))

                gridHomeAdapter = GridHomeAdapter(activity!! ,listFilmPop)
                gridviewHome.adapter = gridHomeAdapter
            }
        })
    }
}