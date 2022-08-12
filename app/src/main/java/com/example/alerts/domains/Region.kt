package com.example.alerts.domains

import java.io.Serializable

class Region(
    val name: String,
    val coords: List<Double>,
    var alert: Boolean
) : Serializable {


}