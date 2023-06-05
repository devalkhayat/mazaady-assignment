package com.mazaady.app.features.auctionDetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemSliderItemBinding
import com.mazaady.app.features.auctionDetails.adapters.holders.SliderItemHolder
import com.mazaady.domain.auctionDetails.models.Media

class SliderAdapter(): RecyclerView.Adapter<SliderItemHolder>()  {

    lateinit var items:List<Media>
    lateinit var itemBinding: ItemSliderItemBinding

    fun setItemsList(_items:List<Media>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderItemHolder {
        itemBinding = ItemSliderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderItemHolder(parent.context,itemBinding)
    }

    override fun onBindViewHolder(holder: SliderItemHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}