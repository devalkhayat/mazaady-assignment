package com.mazaady.data.auctionDetails.local.repoImpl

import com.mazaady.domain.auctionDetails.models.Media
import com.mazaady.domain.auctionDetails.models.AuctionDetails
import com.mazaady.domain.auctionDetails.models.Bidder
import com.mazaady.domain.auctionDetails.models.Seller
import com.mazaady.domain.auctionDetails.repositories.DetailsRepo

class AuctionDetailsRepoImpl:DetailsRepo {
    override fun getDetails(): AuctionDetails {

        var mediaList = mutableListOf(
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/2023-mclaren-artura-101-1655218102.jpg?crop=1.00xw:0.847xh;0,0.153xh&resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/mclaren-elva-102-1573589676.jpg?resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/large-11863-mclaren-765lt-1583521649.jpg?crop=0.797xw:0.798xh;0.0534xw,0.189xh&resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/street-royalty-free-image-1580912705.jpg?crop=1.00xw:0.754xh;0,0.104xh&resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/images/14q1/580519/2014-mclaren-p1-photo-617370-s-986x603.jpg?resize=980:*")
        )
        var bidderList = mutableListOf(
            Bidder(
                name = "محمد الخياط",
                "12:00:00",
                "+20",
                avatarUrl = "https://hips.hearstapps.com/hmg-prod/images/2023-mclaren-artura-101-1655218102.jpg?crop=1.00xw:0.847xh;0,0.153xh&resize=1200:*"
            ),
            Bidder(
                name = "عبد الله سامي",
                "12:00:00",
                "+20",
                avatarUrl = "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),
            Bidder(
                name = "جميل عبد الرحمن",
                "12:00:00",
                "+20",
                avatarUrl = "https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),
            Bidder(
                name = "معين عزام",
                "12:00:00",
                "+20",
                avatarUrl = "https://images.pexels.com/photos/2182970/pexels-photo-2182970.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            )
        )

        var seller = Seller(
            name = "Rashid Abdulsalam",
            phone = "+201112817226",
            rating = 2F,
            productNumber = "4",
            avatarUrl = "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )

        return AuctionDetails(
            startAfterDay = "31",
            startAfterHour = "22",
            startAfterMiniute = "55",
            startDate = "26-11-2021",
            startTime = "13:59:00",
            title = "code 1234",
            rate = 5F,
            currentValue = "2000 $",
            currentValueAfterTax = "2005 $",
            price = "200 $",
            seller = seller,
            bidderList = bidderList, mediaList = mediaList, similarList = getItems()
        )
    }

    private fun getItem():AuctionDetails{

        var mediaList = mutableListOf(
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/2023-mclaren-artura-101-1655218102.jpg?crop=1.00xw:0.847xh;0,0.153xh&resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/mclaren-elva-102-1573589676.jpg?resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/large-11863-mclaren-765lt-1583521649.jpg?crop=0.797xw:0.798xh;0.0534xw,0.189xh&resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/images/street-royalty-free-image-1580912705.jpg?crop=1.00xw:0.754xh;0,0.104xh&resize=1200:*"),
            Media(url = "https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/images/14q1/580519/2014-mclaren-p1-photo-617370-s-986x603.jpg?resize=980:*")
        )

        return AuctionDetails(
            startAfterDay = "03",
            startAfterHour = "22",
            startAfterMiniute = "55",
            startDate = "26-11-2021",
            startTime = "13:59:00",
            title = "code 1234",
            price = "20000 $",
            mediaList = mediaList
        )
    }

    private fun getItems(): MutableList<AuctionDetails> {

        var items = mutableListOf<AuctionDetails>()
        items.add(getItem())
        items.add(getItem())
        items.add(getItem())
        items.add(getItem())
        items.add(getItem())
        items.add(getItem())
        return items
    }


}