package com.mazaady.app.features.addProduct.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemFieldBinding
import com.mazaady.app.databinding.ItemResultBinding
import com.mazaady.app.databinding.ItemSelectedOptionBinding
import com.mazaady.app.features.addProduct.adapters.SelectedOptionsAdapter
import com.mazaady.app.util.models.SelectedOption
import com.mazaady.app.util.models.SelectedProperty

class SelectedOptionItemHolder(val context: Context, val binding: ItemSelectedOptionBinding): RecyclerView.ViewHolder(binding.root) {

 fun  bind(data: SelectedOption){

     binding.apply {
      tvOptionTitle.text=data.info.name
      tvOptionValue.text=data.value


         var selectedOptionsAdapter = SelectedOptionsAdapter()
         selectedOptionsAdapter.setItemsList(data.options as ArrayList)
         rvSelectedOptions.layoutManager = LinearLayoutManager(
             context,
             LinearLayoutManager.VERTICAL,
             false
         )
         rvSelectedOptions.adapter = selectedOptionsAdapter

     }
 }
 }
