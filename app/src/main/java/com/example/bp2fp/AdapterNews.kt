package com.example.bp2fp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterNews (private val listNews:List<NewsModel>):
                        RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){

        val image: ImageView = itemView.findViewById(R.id.iconNews)
        val title: TextView = itemView.findViewById(R.id.txtNewsTitle)
        val desc: TextView = itemView.findViewById(R.id.txtNewsDesc)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cardnews_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelNews = listNews[position]

        holder.image.setImageResource(modelNews.image)
        holder.title.text = modelNews.title
        holder.desc.text = modelNews.desc
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

}
