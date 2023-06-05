package com.mazaady.domain.auctionDetails.models

data class AuctionDetails(
     var startAfterDay:String?=null,
     var startAfterHour:String?=null,
     var startAfterMiniute:String?=null,
     var startDate:String?=null,
     var startTime:String?=null,
     var title:String?=null,
     var rate:Float?=null,
     var currentValue:String?=null,
     var currentValueAfterTax:String?=null,
     var price:String?=null,
     var seller:Seller?=null,
     var type:String?=null,
     var bidderList:MutableList<Bidder>?=mutableListOf(),
     var mediaList:MutableList<Media>?=mutableListOf(),
     var similarList:MutableList<AuctionDetails>?= mutableListOf()

)
