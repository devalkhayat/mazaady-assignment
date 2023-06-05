package com.mazaady.app.features.auctionDetails.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemSliderItemBinding
import com.mazaady.app.util.helper
import com.mazaady.domain.auctionDetails.models.Media

class SliderItemHolder (val context: Context, val binding: ItemSliderItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(data:Media){
        helper.loadImage(context,data.url!!,binding.img)
    }
}