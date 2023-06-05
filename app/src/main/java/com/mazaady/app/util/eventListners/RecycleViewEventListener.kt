package com.mazaady.app.util.eventListners

import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface RecycleViewEventListener:java.io.Serializable {
        fun onClick(obj:Any){}
        fun onClick(obj:Any,label:TextView){}
        fun onClick(obj:Any,label:TextView,rvOptions:RecyclerView){}
        fun onClick(obj:Any,label:TextView,rvOptions:RecyclerView,otherValue:EditText,otherLabel:TextView){}

}