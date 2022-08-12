package com.example.alerts.utils

import android.graphics.Color.convert
import android.graphics.ColorSpace
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.graphics.toColor
import com.example.alerts.domains.UkraineRegions
import kotlin.reflect.typeOf


class ImageAnalyzer {

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateUkraine(ukraineRegions: UkraineRegions, drawable: Drawable) {
        val bmp = (drawable as BitmapDrawable).bitmap
        val y_coordinate = (bmp.height / 2).toInt()
        val x_coordinate = (bmp.width / 2).toInt()

        for (region in ukraineRegions.regions) {
//            println(region.name)
            val color = bmp.getPixel(
                (region.coords[0] * bmp.width).toInt(),
                (region.coords[1] * bmp.height).toInt()
            ).toColor()

            val rColor = color.red()
//            val gColor = color.green()
//            val bColor = color.blue()

            region.alert = rColor >= 0.8

//            println(color.red())
//            println(color.green())
//            println(color.blue())
        }
    }
}