package com.mazaady.app.features.auctionDetails.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mazaady.domain.auctionDetails.models.AuctionDetails
import com.mazaady.domain.auctionDetails.usecases.GetDetailsUseCase
import kotlinx.coroutines.launch

class AuctionDetailsViewModel(private val getDetailsUseCase: GetDetailsUseCase):ViewModel() {

    private  val TAG = "DetailsViewModel"
    private val detailsResponse= MutableLiveData<AuctionDetails>()
    val detailsResponseLive: MutableLiveData<AuctionDetails>
        get() = detailsResponse

    fun getData() {
        viewModelScope.launch {
            detailsResponse.postValue(getDetailsUseCase())
        }
    }
}