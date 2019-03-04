package com.example.mymarvel.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.FrameMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymarvel.R

class SearchFragment : Fragment() {
    companion object homeFrag {
        @Volatile private lateinit var instance: SearchFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recherche,container,false)
    }
}