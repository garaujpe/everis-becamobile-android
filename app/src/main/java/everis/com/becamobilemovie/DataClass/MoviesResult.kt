package everis.com.becamobilemovie.DataClass

import com.google.gson.annotations.SerializedName

data class MoviesResult(
    @SerializedName("pages") val pages: Int,
    @SerializedName("results") val results: List<Movies>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
