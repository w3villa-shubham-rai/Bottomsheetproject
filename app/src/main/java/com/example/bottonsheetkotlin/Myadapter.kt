package com.example.bottonsheetkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class Myadapter(val dataList : ArrayList<datamodel>): RecyclerView.Adapter<Myadapter.MyviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.viewtemplate,parent,false)
        return MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
       holder.textView.setText(dataList.get(position).header)
        holder.textviewsceand.setText(dataList.get(position).desc)
    }
    override fun getItemCount(): Int {
        return dataList.size
    }


    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var textView=itemView.findViewById<TextView>(R.id.textView);
        var textviewsceand=itemView.findViewById<TextView>(R.id.textviewsceand);
    }
}
