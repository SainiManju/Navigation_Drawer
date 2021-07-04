package com.example.navigation_drawer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ServicesFragment : Fragment() {
    var rv: RecyclerView? = null                // RecyclerView must not be null
    var adapterclass: Adapterclass? = null      //Adapter must not be null
    var list: MutableList<DataClass>? = null    //List must not be null
    override fun onCreateView(                  //This method creates and returns the view Hierarchy
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         //inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_services2, container, false)
        rv = v.findViewById(R.id.rv)                 // finds the view in recycler view
        val list = ArrayList<DataClass>()            // creating an ArrayList to store list data using the DataClass
        list.add(DataClass("Service 1"))      // Adding Data in the list
        list.add(DataClass("Service 2"))
        list.add(DataClass("Service 3"))
        list.add(DataClass("Service 4"))
        list.add(DataClass("Service 5"))
        list.add(DataClass("Service 6"))
        list.add(DataClass("Service 7"))
        list.add(DataClass("Service 8"))
        list.add(DataClass("Service 9"))
        list.add(DataClass("Service 10"))
        list.add(DataClass("Service 11"))
        list.add(DataClass("Service 12"))
        list.add(DataClass("Service 13"))
        list.add(DataClass("Service 14"))
        list.add(DataClass("Service 15"))
        list.add(DataClass("Service 16"))
        list.add(DataClass("Service 17"))
        list.add(DataClass("Service 18"))
        list.add(DataClass("Service 19"))
        list.add(DataClass("Service 20"))
        list.add(DataClass("Service 21"))
        list.add(DataClass("Service 22"))
        list.add(DataClass("Service 23"))

      // A layout manager positions item views inside a RecyclerView
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        rv?.setLayoutManager(linearLayoutManager)

        //creating the adapter
        val adapter = Adapterclass(list)
        // now adding the adapter to RecyclerView
        rv?.adapter = adapter
        return v
    }
}




