package com.mazaady.app.features.auctionDetails.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.mazaady.app.databinding.FragmentAuctionDetailsBinding
import com.mazaady.app.features.auctionDetails.adapters.AuctionsAdapter
import com.mazaady.app.features.auctionDetails.adapters.BiddersAdapter
import com.mazaady.app.features.auctionDetails.adapters.SliderAdapter
import com.mazaady.app.features.auctionDetails.viewmodels.AuctionDetailsViewModel
import com.mazaady.app.util.helper
import com.mazaady.domain.auctionDetails.models.Media
import com.mazaady.domain.auctionDetails.models.AuctionDetails
import com.mazaady.domain.auctionDetails.models.Bidder
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuctionDetailsFragment : Fragment() {

    private  val TAG = "DetailsFragment"
    private lateinit var binding: FragmentAuctionDetailsBinding
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var biddersAdapter: BiddersAdapter
    private lateinit var auctionsAdapter: AuctionsAdapter
    private val auctionDetailsViewModel by viewModel<AuctionDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAuctionDetailsBinding.inflate(inflater,container,false)
        init()
        observers()
        events()
        return binding.root
    }

    private fun events() {

    }

    private fun observers() {
        auctionDetailsViewModel.detailsResponseLive.observe(viewLifecycleOwner, Observer {
          showData(it)
      })
    }

    private fun showData(it: AuctionDetails?) {

        showSlider(it?.mediaList!!)
        showInfo(it)
        showBidders(it.bidderList!!)
        showSeller(it)
        showSimilar(it?.similarList!!)

    }
    private fun showSlider(items:MutableList<Media>){
        binding.apply {

            sliderAdapter = SliderAdapter()
            sliderAdapter.setItemsList(items)
           includeDetailsHeader.recyclerView.apply {

               adapter = sliderAdapter
               //////////////////
               var manager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
               val snapHelper: SnapHelper = PagerSnapHelper()
               this.setLayoutManager(manager)
               this.setOnFlingListener(null)
               snapHelper.attachToRecyclerView(this)
               //////////////

           }
            includeDetailsHeader.indicator.attachToRecyclerView(includeDetailsHeader.recyclerView)

            includeDetailsHeader.apply {
                tvStartAfterDays.text="31"
                tvStartAfterHours.text="22"
                tvStartAfterMinutes.text="55"
                tvDate.text="26-11-2021"
                tvTime.text="13:59:00"
            }

        }

    }
    private fun showInfo(item:AuctionDetails){
        binding.apply {

            includeDetailsInfo.apply {
                tvCode.text=item.title
                rateBar.rating=item.rate!!
                tvCurrentValue.text=item.currentValue
                tvCurrentValueAfterTax.text=item.currentValueAfterTax
                tvPrice.text=item.price
            }
        }
    }
    private fun showBidders(items:MutableList<Bidder>){

        binding.apply {

            biddersAdapter = BiddersAdapter()
            biddersAdapter.setItemsList(items)
            includeDetailsBidders.recyclerView.apply {

                this.adapter = biddersAdapter
                //////////////////
                var manager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                this.setLayoutManager(manager)
                this.isNestedScrollingEnabled=false
                //////////////

            }




        }

    }
    private fun showSeller(item:AuctionDetails){
        binding.apply {

            includeDetailsSeller.apply {
                helper.loadImage(requireContext(),item.seller?.avatarUrl!!,img)
                tvName.text=item.seller?.name
                rateBar.rating=item.seller?.rating!!
                tvPhone.text=item.seller?.phone
                tvProducts.text="${getString(com.mazaady.resources.R.string.auction_products)} ${item.seller?.productNumber!!}"
            }
        }
    }
    private fun showSimilar(items:MutableList<AuctionDetails>){
        binding.apply {

            includeDetailsSimilarHeader.apply {
                auctionsAdapter = AuctionsAdapter()
                auctionsAdapter.setItemsList(items)
                includeDetailsSimilarHeader.recyclerView.apply {

                    this.adapter = auctionsAdapter
                    //////////////////
                    var manager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    this.setLayoutManager(manager)
                    //////////////

                }
            }
        }
    }

    private fun init() {
        auctionDetailsViewModel.getData()
    }


}