package com.example.mymarvel.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import com.example.mymarvel.Data.FilmCollection
import com.example.mymarvel.R


class GridHomeAdapter(private var context: Context, val films : FilmCollection?, val books : Array<String>) : BaseAdapter(){

    override fun getCount(): Int {return books.size;}
    override fun getItem(position: Int): Any {return 0;} //films.listFilm[position]
    override fun getItemId(position: Int): Long {return position.toLong()}

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.grid_cell_layout,parent,false)

        val txtNameCell = view.findViewById<TextView>(R.id.txtNameCellGrid)
        txtNameCell.text = books[position] //films.listFilm[position].title

        return view
    }
}