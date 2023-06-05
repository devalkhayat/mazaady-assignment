package com.mazaady.app.features.auctionDetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemAuctionBinding
import com.mazaady.app.databinding.ItemSliderItemBinding
import com.mazaady.app.features.auctionDetails.adapters.holders.AuctionItemHolder
import com.mazaady.app.features.auctionDetails.adapters.holders.SliderItemHolder
import com.mazaady.domain.auctionDetails.models.AuctionDetails

class AuctionsAdapter(): RecyclerView.Adapter<AuctionItemHolder>()  {

    lateinit var items:List<AuctionDetails>
    lateinit var itemBinding: ItemAuctionBinding

    fun setItemsList(_items:List<AuctionDetails>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuctionItemHolder {
        itemBinding = ItemAuctionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AuctionItemHolder(parent.context,itemBinding)
    }

    override fun onBindViewHolder(holder: AuctionItemHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}