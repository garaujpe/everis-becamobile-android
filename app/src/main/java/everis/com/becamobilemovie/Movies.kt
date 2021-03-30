package everis.com.becamobilemovie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var id: Int,
    var name: String,
    var capa: String,
    var sinopse: String,
    var raiting: Double,
    var lançamento: String
): Parcelable
