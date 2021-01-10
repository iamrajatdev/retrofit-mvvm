package com.example.retrofitmvvmtest.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class SupportResponse(
    @ColumnInfo(name = "Url") @SerializedName("url") var url: String,
    @ColumnInfo(name = "Text") @SerializedName("text") var text: String
)