package com.mazaady.app.features.addProduct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemPopuplistBinding
import com.mazaady.app.features.addProduct.adapters.holders.PopupListItemHolder
import com.mazaady.app.features.addProduct.fragments.PopupListFragment
import com.mazaady.app.util.eventListners.RecycleViewEventListener

class PopupListAdapter<T>(val holderFragment:PopupListFragment, val onClickListener: RecycleViewEventListener): RecyclerView.Adapter<PopupListItemHolder<T>>()  {

    lateinit var items:List<T>
    lateinit var itemBinding: ItemPopuplistBinding

    fun setItemsList(_items:List<T>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopupListItemHolder<T> {
        itemBinding = ItemPopuplistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopupListItemHolder<T>(parent.context,itemBinding,holderFragment,onClickListener)
    }

    override fun onBindViewHolder(holder: PopupListItemHolder<T>, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}