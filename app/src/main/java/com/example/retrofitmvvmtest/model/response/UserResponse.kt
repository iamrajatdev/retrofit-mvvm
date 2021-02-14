package com.example.retrofitmvvmtest.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
<<<<<<< HEAD
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_response")
data class UserResponse(
    @ColumnInfo(name = "Id") @SerializedName("id") var id: Int,
=======
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "user_response")
data class UserResponse(
    @ColumnInfo(name = "Id") @SerializedName("id") @PrimaryKey(autoGenerate = true) var id: Int,
>>>>>>> room-implementation
    @ColumnInfo(name = "Email") @SerializedName("email") var email: String,
    @ColumnInfo(name = "FirstName") @SerializedName("first_name") var firstName: String,
    @ColumnInfo(name = "LastName") @SerializedName("last_name") var lastName: String,
    @ColumnInfo(name = "Avatar") @SerializedName("avatar") var avatar: String
)