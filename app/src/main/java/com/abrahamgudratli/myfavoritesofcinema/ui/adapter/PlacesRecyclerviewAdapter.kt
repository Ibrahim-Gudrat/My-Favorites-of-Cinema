package com.abrahamgudratli.myfavoritesofcinema.ui.adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abrahamgudratli.myfavoritesofcinema.R
import com.abrahamgudratli.myfavoritesofcinema.data.PlacesToGo
import com.abrahamgudratli.myfavoritesofcinema.ui.placestogo.PlacesToGoFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.abrahamgudratli.myfavoritesofcinema.ui.adapter.PlacesRecyclerviewAdapter as PlacesRecyclerviewAdapter1

class PlacesRecyclerviewAdapter(private val context: Context) : RecyclerView.Adapter<PlacesRecyclerviewAdapter1.ViewHolder>() {

    private var list = emptyList<PlacesToGo>()

    inner class ViewHolder(item : View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = list[position]
        holder.itemView.tvTitle.text = currentItem.title
        holder.itemView.tvDescription.text = currentItem.description
        holder.itemView.tvRating.text = currentItem.rating
        val url = currentItem.image
        Glide.with(context).load(url).into(holder.itemView.ivPicture)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(places: List<PlacesToGo>) {
        this.list = places
        notifyDataSetChanged()
    }

}