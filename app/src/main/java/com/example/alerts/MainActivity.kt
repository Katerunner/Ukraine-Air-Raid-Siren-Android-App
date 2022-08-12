package com.example.alerts

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alerts.domains.UkraineRegions
import com.example.alerts.networkAdapter.DownloadImage
import com.example.alerts.utils.ImageAnalyzer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val diInstance = DownloadImage()
    val iaInstance = ImageAnalyzer()
    val ukraineRegions: UkraineRegions = UkraineRegions().populateRegions()
    var currentRegion = ukraineRegions.regions[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val regionsNames = ArrayList<String>()
        for (region in ukraineRegions.regions) {
            regionsNames.add(region.name)
        }

        val aa = ArrayAdapter(
            this,
            R.layout.region_item_spinner,
            R.id.regionDropdownSpinner,
            regionsNames
        )

        updateUiBasedOnCurrentRegionStatus()

        aa.setDropDownViewResource(R.layout.region_item_spinner)

        with(regionChooseSpinner)
        {
            adapter = aa
            setSelection(0, false)
            onItemSelectedListener = this@MainActivity
            prompt = "Select your favourite language"
            gravity = Gravity.CENTER

        }
        val threadForAlertUpdate: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!this.isInterrupted) {
                        sleep(10000)
                        runOnUiThread {
                            updateUiBasedOnCurrentRegionStatus()
                        }
                    }
                } catch (e: InterruptedException) {
                }
            }
        }

        threadForAlertUpdate.start()

        val threadForMapUpdate: Thread = object : Thread() {
            override fun run() {
                try {
                    while (!this.isInterrupted) {
                        sleep(100)
                        when (mapTitle.text) {
                            "◐ Ukraine Alert Map ◐" -> {
                                mapTitle.text = "◓ Ukraine Alert Map ◓"
                            }
                            "◓ Ukraine Alert Map ◓" -> {
                                mapTitle.text = "◑ Ukraine Alert Map ◑"
                            }
                            "◑ Ukraine Alert Map ◑" -> {
                                mapTitle.text = "◒ Ukraine Alert Map ◒"
                            }
                            else -> {
                                mapTitle.text = "◐ Ukraine Alert Map ◐"
                            }
                        }

                        runOnUiThread {
                            val mapImage =
                                diInstance.setImageViewURLDrawable("https://alerts.com.ua/map.png")
                            mapViewIV.setImageDrawable(mapImage)

                            if (mapImage != null) {
                                iaInstance.updateUkraine(ukraineRegions, mapImage)
                            }
                        }
                    }
                } catch (e: InterruptedException) {
                }
            }
        }

        threadForMapUpdate.start()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        currentRegion = ukraineRegions.regions[p2]
        if (p1 != null) {
            Toast.makeText(
                p1.context,
                "Your region is now " + currentRegion.name,
                Toast.LENGTH_SHORT
            ).show()
        }

        updateUiBasedOnCurrentRegionStatus()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun updateUiBasedOnCurrentRegionStatus() {
        if (currentRegion.alert) {
            statusText.text = "Alert!"
            statusText.setTextColor(Color.parseColor("#CC0000"));
            regionName.text = currentRegion.name
            regionName.setTextColor(Color.parseColor("#CC0000"));

            val drawableResourceId =
                this.resources.getIdentifier("alert_back", "drawable", this.packageName)
            backgroundLayout.setBackgroundResource(drawableResourceId)
        } else {
            statusText.text = "4.5.0"
            statusText.setTextColor(Color.parseColor("#323232"))
            regionName.text = currentRegion.name
            regionName.setTextColor(Color.parseColor("#323232"))

            val drawableResourceId =
                this.resources.getIdentifier("calm_back", "drawable", this.packageName)
            backgroundLayout.setBackgroundResource(drawableResourceId)
        }
    }
}