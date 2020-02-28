package com.renatoramos.rickandmorty.domain.viewobject.locations

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LocationShortViewObject(
    var name: String = "",
    var url: String = ""
): Parcelable
