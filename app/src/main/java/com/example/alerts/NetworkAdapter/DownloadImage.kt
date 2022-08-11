package com.example.alerts.NetworkAdapter

import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class DownloadImage {
    fun setImageViewURLDrawable(imageView: ImageView, url: String) {
        class DownloadImageTask : AsyncTask<Int?, Void?, Int>() {
            private var drawable: Drawable? = null

            override fun onPostExecute(result: Int) {
                super.onPostExecute(result)
                imageView.setImageDrawable(drawable)
            }

            override fun doInBackground(vararg p0: Int?): Int {
                drawable = loadImageFromWeb(url)
                return 0
            }

            private fun loadImageFromWeb(url: String): Drawable? {
                return try {
                    val `is`: InputStream = URL(url).content as InputStream
                    Drawable.createFromStream(`is`, "src name")
                } catch (e: Exception) {
                    println("Exc=$e")
                    null
                }
            }
        }

        DownloadImageTask().execute()
    }
}
