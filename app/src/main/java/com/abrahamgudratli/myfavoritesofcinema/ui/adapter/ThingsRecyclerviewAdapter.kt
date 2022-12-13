package com.abrahamgudratli.myfavoritesofcinema.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGo
import com.abrahamgudratli.myfavoritesofcinema.data.ThingsToDo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class ThingsRecyclerviewAdapter() :
    RecyclerView.Adapter<ThingsRecyclerviewAdapter.ViewHolder>() {

    var list = emptyList<ThingsToDo>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.itemView.tvTitle.text = currentItem.title
        holder.itemView.tvDescription.text = currentItem.description
        holder.itemView.tvRating.text = currentItem.rating
        val url = currentItem.image

        //Glide.with(context).load(url).into(holder.itemView.ivPicture)
        holder.itemView.ivPicture.setImageURI(url.toUri())

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(things: List<ThingsToDo>) {
        this.list = things
        notifyDataSetChanged()
    }

}