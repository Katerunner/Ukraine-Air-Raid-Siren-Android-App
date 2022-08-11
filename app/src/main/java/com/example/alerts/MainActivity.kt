package com.example.alerts

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.alerts.NetworkAdapter.DownloadImage
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val diInstance = DownloadImage()

        val thread: Thread = object : Thread() {
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
                            diInstance.setImageViewURLDrawable(
                                mapViewIV,
                                "https://alerts.com.ua/map.png"
                            )
                        }
                    }
                } catch (e: InterruptedException) {
                }
            }
        }

        thread.start()
    }
}