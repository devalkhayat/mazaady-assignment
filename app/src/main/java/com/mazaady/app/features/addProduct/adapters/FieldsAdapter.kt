package com.mazaady.app.features.addProduct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemFieldBinding
import com.mazaady.app.features.addProduct.adapters.holders.FieldItemHolder
import com.mazaady.app.util.eventListners.RecycleViewEventListener

class FieldsAdapter<T>(val onClickListener: RecycleViewEventListener): RecyclerView.Adapter<FieldItemHolder<T>>()  {

    lateinit var items:List<T>
    lateinit var itemBinding: ItemFieldBinding

    fun setItemsList(_items:List<T>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldItemHolder<T> {
        itemBinding = ItemFieldBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FieldItemHolder<T>(parent.context,itemBinding,onClickListener)
    }

    override fun onBindViewHolder(holder: FieldItemHolder<T>, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}