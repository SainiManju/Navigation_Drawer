package com.example.navigation_drawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapterclass(var datalist: List<DataClass>) : RecyclerView.Adapter<Adapterclass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {       //This method is returning the view for
        val layoutInflater = LayoutInflater.from(parent.context)                          //each item in the list
        val  v = layoutInflater.inflate(R.layout.cardview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {             //This method is binding the data on the list
        holder.name.text = datalist[position].name
    }

    override fun getItemCount(): Int {                                            //This method is giving the size of the list
        return datalist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {    //The class is holding the listView
        var name: TextView

        init {
            name = itemView.findViewById(R.id.cardView_ServiceFragment_TextView)     //finds the itemView by using the Id
        }
    }

}