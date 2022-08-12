package com.example.alerts.domains

class UkraineRegions(var regions: ArrayList<Region> = ArrayList<Region>()) {
    fun populateRegions(): UkraineRegions {
        regions.add(Region("Lviv Region", listOf(100.0 / 1000.0, 200.0 / 670.0), false))
        regions.add(Region("Rivne Region", listOf(246.0 / 1000.0, 143.0 / 670.0), false))
        regions.add(Region("Transcarpathian Region", listOf(64.0 / 1000.0, 342.0 / 670.0), false))
        regions.add(Region("Ivano-Frankivsk Region", listOf(140.0 / 1000.0, 323.0 / 670.0), false))
        regions.add(Region("Ternopil Region", listOf(200.0 / 1000.0, 250.0 / 670.0), false))
        regions.add(Region("Khmelnytskyi Region", listOf(250.0 / 1000.0, 250.0 / 670.0), false))
        regions.add(Region("Chernivtsi Region", listOf(207.0 / 1000.0, 356.0 / 670.0), false))
        regions.add(Region("Zhytomyr Region", listOf(344.0 / 1000.0, 160.0 / 670.0), false))
        regions.add(Region("Vinnytsia Region", listOf(360.0 / 1000.0, 300.0 / 670.0), false))
        regions.add(Region("Kyiv Region", listOf(455.0 / 1000.0, 225.0 / 670.0), false))
        regions.add(Region("Kyiv City", listOf(466.0 / 1000.0, 172.0 / 670.0), false))
        regions.add(Region("Cherkasy Region", listOf(500.0 / 1000.0, 300.0 / 670.0), false))
        regions.add(Region("Kirovograd Region", listOf(550.0 / 1000.0, 340.0 / 670.0), false))
        regions.add(Region("Mykolaiv Region", listOf(530.0 / 1000.0, 410.0 / 670.0), false))
        regions.add(Region("Odessa Region", listOf(450.0 / 1000.0, 450.0 / 670.0), false))
        regions.add(Region("Chernihiv Region", listOf(570.0 / 1000.0, 104.0 / 670.0), false))
        regions.add(Region("Sumy Region", listOf(665.0 / 1000.0, 123.0 / 670.0), false))
        regions.add(Region("Poltava Region", listOf(653.0 / 1000.0, 228.0 / 670.0), false))
        regions.add(Region("Kharkiv Region", listOf(800.0 / 1000.0, 237.0 / 670.0), false))
        regions.add(Region("Dnipropetrovsk Region", listOf(700.0 / 1000.0, 337.0 / 670.0), false))
        regions.add(Region("Kherson Region", listOf(642.0 / 1000.0, 472.0 / 670.0), false))
        regions.add(Region("Zaporizhya Region", listOf(750.0 / 1000.0, 450.0 / 670.0), false))
        regions.add(Region("Luhansk Region", listOf(920.0 / 1000.0, 290.0 / 670.0), false))
        regions.add(Region("Donetsk Region", listOf(860.0 / 1000.0, 370.0 / 670.0), false))
        return this
    }

}