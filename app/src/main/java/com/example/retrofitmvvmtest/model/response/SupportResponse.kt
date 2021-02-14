package com.example.retrofitmvvmtest.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "support_response")
data class SupportResponse(
    @ColumnInfo(name = "Url") @SerializedName("url") private var url: String,
    @ColumnInfo(name = "Text") @SerializedName("text") private var text: String
)