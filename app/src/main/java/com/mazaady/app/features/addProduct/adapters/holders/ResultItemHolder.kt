package com.mazaady.app.features.addProduct.adapters.holders

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mazaady.app.databinding.ItemFieldBinding
import com.mazaady.app.databinding.ItemResultBinding
import com.mazaady.app.features.addProduct.adapters.ResultAdapter
import com.mazaady.app.features.addProduct.adapters.SelectedOptionsAdapter
import com.mazaady.app.util.models.SelectedProperty

class ResultItemHolder(val context: Context, val binding: ItemResultBinding): RecyclerView.ViewHolder(binding.root) {

 fun  bind(data:SelectedProperty){

     binding.apply {
      tvPropertyTitle.text=data.info.name
      tvPropertyValue.text=data.value

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
