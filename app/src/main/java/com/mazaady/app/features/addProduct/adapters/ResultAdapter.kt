package com.mazaady.app.features.addProduct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemFieldBinding
import com.mazaady.app.databinding.ItemResultBinding
import com.mazaady.app.features.addProduct.adapters.holders.FieldItemHolder
import com.mazaady.app.features.addProduct.adapters.holders.ResultItemHolder
import com.mazaady.app.util.eventListners.RecycleViewEventListener
import com.mazaady.app.util.models.SelectedProperty

class ResultAdapter(): RecyclerView.Adapter<ResultItemHolder>()  {

    lateinit var items:List<SelectedProperty>
    lateinit var itemBinding: ItemResultBinding

    fun setItemsList(_items:List<SelectedProperty>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemHolder {
        itemBinding = ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultItemHolder(parent.context,itemBinding)
    }

    override fun onBindViewHolder(holder: ResultItemHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}