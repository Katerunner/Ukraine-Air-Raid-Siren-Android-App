package com.example.alerts.networkAdapter

import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.widget.ImageView
import java.io.InputStream
import java.net.URL

class DownloadImage {
    var drawable: Drawable? = null
    fun setImageViewURLDrawable(url: String): Drawable? {

        class DownloadImageTask() : AsyncTask<Int?, Void?, Int>() {

            override fun onPostExecute(result: Int) {
                super.onPostExecute(result)
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

        var task = DownloadImageTask()
        task.execute()

        return drawable
    }
}
