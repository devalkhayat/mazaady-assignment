package com.mazaady.domain.auctionDetails.repositories

import com.mazaady.domain.auctionDetails.models.AuctionDetails

interface DetailsRepo {
    fun getDetails():AuctionDetails
}