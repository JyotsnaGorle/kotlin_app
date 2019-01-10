package com.example.jol.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData(val name: String,
                    val description: String,
                    var image: Int,
                    val imagePath: String) : Parcelable