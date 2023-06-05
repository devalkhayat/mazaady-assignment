package com.mazaady.app.features.addProduct.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemPopuplistBinding
import com.mazaady.app.features.addProduct.fragments.PopupListFragment
import com.mazaady.app.util.eventListners.RecycleViewEventListener
import com.mazaady.domain.addProduct.models.MainCategory
import com.mazaady.domain.addProduct.models.SubCategory
import com.mazaady.domain.addProduct.models.Option


class PopupListItemHolder<T> (val context: Context, val binding: ItemPopuplistBinding, val holderFragment: PopupListFragment, val onClickListener: RecycleViewEventListener): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: T){
        binding.apply {
            when(data){
               is MainCategory->{

                   tvTitle.text=data.name
                   root.setOnClickListener {
                       onClickListener.onClick(data)
                       holderFragment.dismiss()
                   }

                }

                is SubCategory->{

                    tvTitle.text=data.name
                    root.setOnClickListener {
                        onClickListener.onClick(data)
                        holderFragment.dismiss()
                    }

                }
                is Option->{

                    tvTitle.text=data.name
                    root.setOnClickListener {
                        onClickListener.onClick(data)
                        holderFragment.dismiss()
                    }

                }
            }

        }

    }
}