package com.wai.coroutines.pojo

import com.google.gson.annotations.SerializedName

data class SatinBean(
    var name: String,
    var text: String,

    var created_at: String,
    var comment: Int,
    var favourite: Int,
    var love: Int,

    @SerializedName("image_small")
    var image: String

)
