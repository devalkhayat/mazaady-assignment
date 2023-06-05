package com.mazaady.domain.auctionDetails.usecases


import com.mazaady.domain.auctionDetails.repositories.DetailsRepo


class GetDetailsUseCase(private val detailsRepo: DetailsRepo) {
    suspend operator fun invoke()=detailsRepo.getDetails()
}
