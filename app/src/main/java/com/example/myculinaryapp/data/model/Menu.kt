package com.example.myculinaryapp.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Menu(
    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var name: String,
    var price: Double,
    var desc: String,
    var location: String,
    var googleMapsLink : String
) : Parcelable
