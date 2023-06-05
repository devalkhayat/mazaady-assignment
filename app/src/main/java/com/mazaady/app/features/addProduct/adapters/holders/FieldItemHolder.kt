package com.mazaady.app.features.addProduct.adapters.holders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemFieldBinding
import com.mazaady.app.util.eventListners.RecycleViewEventListener
import com.mazaady.domain.addProduct.models.Property
import com.mazaady.domain.addProduct.models.Child


class FieldItemHolder<T> (val context: Context, val binding: ItemFieldBinding,val onClickListener: RecycleViewEventListener): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: T){
        binding.apply {
            tvNewValue.visibility= View.GONE
            etNewValue.visibility= View.GONE

            when(data){
               is Property ->{

                   tvTitle.text=data.name
                   tvSelectedText.setOnClickListener {
                       onClickListener.onClick(data,tvSelectedText,rvOptions)
                   }

                }
                is Child ->{

                    tvTitle.text=data.name
                    tvSelectedText.setOnClickListener {
                        onClickListener.onClick(data,tvSelectedText,rvOptions,etNewValue,tvNewValue)
                    }


                }

            }

        }

    }
}