package com.mazaady.app.features.addProduct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemFieldBinding
import com.mazaady.app.databinding.ItemResultBinding
import com.mazaady.app.databinding.ItemSelectedOptionBinding
import com.mazaady.app.features.addProduct.adapters.holders.FieldItemHolder
import com.mazaady.app.features.addProduct.adapters.holders.ResultItemHolder
import com.mazaady.app.features.addProduct.adapters.holders.SelectedOptionItemHolder
import com.mazaady.app.util.eventListners.RecycleViewEventListener
import com.mazaady.app.util.models.SelectedOption
import com.mazaady.app.util.models.SelectedProperty

class SelectedOptionsAdapter(): RecyclerView.Adapter<SelectedOptionItemHolder>()  {

    lateinit var items:List<SelectedOption>
    lateinit var itemBinding: ItemSelectedOptionBinding

    fun setItemsList(_items:List<SelectedOption>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedOptionItemHolder {
        itemBinding = ItemSelectedOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectedOptionItemHolder(parent.context,itemBinding)
    }

    override fun onBindViewHolder(holder: SelectedOptionItemHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}