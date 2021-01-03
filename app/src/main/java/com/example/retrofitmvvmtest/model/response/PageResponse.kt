package com.example.retrofitmvvmtest.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "page_response")
data class PageResponse(
    @ColumnInfo(name = "Id")@PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "Page")@SerializedName("page") var page: Int,
    @ColumnInfo(name = "Per_Page")@SerializedName("per_page") var per_page: Int,
    @ColumnInfo(name = "Total")@SerializedName("total") var total: Int,
    @ColumnInfo(name = "Total_Page") @SerializedName("total_pages") var total_pages: Int,
    @TypeConverters(UserResponse::class) @ColumnInfo(name = "Data") @SerializedName("data") var data: List<UserResponse>,
    @ColumnInfo(name = "Support") @SerializedName("support") var support: SupportResponse,
)