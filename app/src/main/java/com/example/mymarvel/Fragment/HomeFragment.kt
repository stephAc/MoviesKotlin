package com.example.mymarvel.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymarvel.Adapter.GridHomeAdapter
import com.example.mymarvel.R
import com.example.mymarvel.Utilities.ApiFilm.ApiFilm.createApiService
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var gridHomeAdapter: GridHomeAdapter
    private var book: Array<String> = arrayOf("green", "red", "blue","green", "red", "blue","green",
        "red", "blue","green", "red", "blue","green", "red", "blue","green", "red", "blue",
        "green", "red", "blue","green", "red", "blue","green", "red", "blue","green", "red",
        "blue","green", "red", "blue","green", "red", "blue")

    companion object homeFrag {
        @Volatile private lateinit var instance: HomeFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createApiService()

        gridHomeAdapter = GridHomeAdapter(activity!! ,book)
        gridviewHome.adapter = gridHomeAdapter
    }
}