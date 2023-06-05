package com.mazaady.app.features.auctionDetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemBidderBinding
import com.mazaady.app.databinding.ItemSliderItemBinding
import com.mazaady.app.features.auctionDetails.adapters.holders.BidderItemHolder
import com.mazaady.app.features.auctionDetails.adapters.holders.SliderItemHolder
import com.mazaady.domain.auctionDetails.models.Bidder
import com.mazaady.domain.auctionDetails.models.Media

class BiddersAdapter(): RecyclerView.Adapter<BidderItemHolder>()  {

    lateinit var items:List<Bidder>
    lateinit var itemBinding: ItemBidderBinding

    fun setItemsList(_items:List<Bidder>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BidderItemHolder {
        itemBinding = ItemBidderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BidderItemHolder(parent.context,itemBinding)
    }

    override fun onBindViewHolder(holder: BidderItemHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}