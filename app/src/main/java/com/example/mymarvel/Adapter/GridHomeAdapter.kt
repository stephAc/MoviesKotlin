package com.example.mymarvel.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.mymarvel.Models.Films
import com.example.mymarvel.R
import com.example.mymarvel.Ui.FilmDetailsActivity
import com.squareup.picasso.Picasso

class GridHomeAdapter(private var context: Context, val listFi : List<Films>) : BaseAdapter(){

    override fun getCount(): Int {return listFi.size;}
    override fun getItem(position: Int): Any {return listFi[position];}
    override fun getItemId(position: Int): Long {return position.toLong()}

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.grid_cell_layout,parent,false)

        view.setOnClickListener {
            val intent = Intent(context, FilmDetailsActivity::class.java)
            intent.putExtra("filmPosterPath", listFi[position].poster_path)
            intent.putExtra("filmTitle", listFi[position].original_title)
            intent.putExtra("filmOverview", listFi[position].overview)
            intent.putExtra("filmDate", listFi[position].release_date)
            context.startActivity(intent)
        }

        val imgPoster = view.findViewById<ImageView>(R.id.posterView)
        Picasso.get().load("https://image.tmdb.org/t/p/w342/${listFi[position].poster_path}").into(imgPoster)
        return view
    }
}

