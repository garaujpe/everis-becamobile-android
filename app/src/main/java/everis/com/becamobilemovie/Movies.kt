package everis.com.becamobilemovie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val name: String,
    @SerializedName("poster_path") val capa: String?,
    @SerializedName("overview") val sinopse: String,
    @SerializedName("vote_average") val raiting: Double,
    @SerializedName("release_date") val lançamento: String
): Parcelable
