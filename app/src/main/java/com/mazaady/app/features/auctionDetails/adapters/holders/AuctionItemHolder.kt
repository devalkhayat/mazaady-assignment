package com.mazaady.app.features.auctionDetails.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemAuctionBinding
import com.mazaady.app.databinding.ItemBidderBinding
import com.mazaady.app.util.helper
import com.mazaady.domain.auctionDetails.models.AuctionDetails
import com.mazaady.domain.auctionDetails.models.Bidder

class AuctionItemHolder (val context: Context, val binding: ItemAuctionBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: AuctionDetails){

        binding.apply {
            helper.loadImage(context,data.mediaList?.get(0)?.url!!,binding.img)
            tvTitle.text=context.getString(com.mazaady.resources.R.string.auction_product_name)
            tvType.text=context.getString(com.mazaady.resources.R.string.auction_direct_auction)
            //
            tvStartAfterDays.text="31"
            tvStartAfterHours.text="22"
            tvStartAfterMinutes.text="55"
            tvPrice.text="20000"
            tvCurrency.text=context.getString(com.mazaady.resources.R.string.auction_currency)

        }

    }
}