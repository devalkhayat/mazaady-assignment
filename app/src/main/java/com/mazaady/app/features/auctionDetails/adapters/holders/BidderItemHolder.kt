package com.mazaady.app.features.auctionDetails.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemBidderBinding
import com.mazaady.app.databinding.ItemSliderItemBinding
import com.mazaady.app.util.helper
import com.mazaady.domain.auctionDetails.models.Bidder
import com.mazaady.domain.auctionDetails.models.Media

class BidderItemHolder (val context: Context, val binding: ItemBidderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Bidder){

        binding.apply {
            helper.loadImage(context,data.avatarUrl!!,binding.img)
            tvName.text=data.name
            tvTime.text=data.time
            tvValue.text=data.value
        }

    }
}