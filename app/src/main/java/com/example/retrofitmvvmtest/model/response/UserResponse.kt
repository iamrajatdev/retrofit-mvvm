package com.example.retrofitmvvmtest.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_response")
data class UserResponse(
    @ColumnInfo(name = "Id") @SerializedName("id") var id: Int,
    @ColumnInfo(name = "Email") @SerializedName("email") var email: String,
    @ColumnInfo(name = "FirstName") @SerializedName("first_name") var firstName: String,
    @ColumnInfo(name = "LastName") @SerializedName("last_name") var lastName: String,
    @ColumnInfo(name = "Avatar") @SerializedName("avatar") var avatar: String
)