package com.payelpaul.mvmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.payelpaul.mvmvvm.R
import com.payelpaul.mvmvvm.databinding.ItemListBinding
import com.payelpaul.mvmvvm.models.Artiest

class ArtistAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artiest>()

    fun setList(artists:List<Artiest>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ItemListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }


}
class MyViewHolder(val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(artiest: Artiest){
        binding.titleTextView.text=artiest.name
        binding.descriptionTextView.text = artiest.popularity.toString()
        val posterURL = "https://image.tmdb.org/t/p/w500"+artiest.profile_path

        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }
}