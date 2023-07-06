package com.example.bottonsheetkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import kotlinx.coroutines.currentCoroutineContext
import kotlin.coroutines.coroutineContext

class Myadapter(val dataList : ArrayList<datamodel>): RecyclerView.Adapter<Myadapter.MyviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.viewtemplate,parent,false)
        return MyviewHolder(view)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
       holder.textView.setText(dataList[position].header)
        holder.textviewsceand.setText(dataList[position].desc)

        val imageUrl = dataList[position].img
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.user_img)



    }
    override fun getItemCount(): Int {
        return dataList.size
    }


    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        var textView=itemView.findViewById<TextView>(R.id.textView);
        var textviewsceand=itemView.findViewById<TextView>(R.id.textView_tittle);
        var user_img=itemView.findViewById<ImageView>(R.id.user_img);
    }
}
