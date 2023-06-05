package com.mazaady.app.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mazaady.resources.R



object helper {

    fun loadImage(context: Context, path:String, photo: ImageView){
        Glide.with(context).load(path)
            .placeholder(R.color.app_gray) // placeholder
            .error(R.color.app_gray) // image broken
            .fallback(R.color.app_gray) // no image
            .into(photo)
    }


}