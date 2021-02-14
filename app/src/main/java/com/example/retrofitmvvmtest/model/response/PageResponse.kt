package com.example.retrofitmvvmtest.model.response

<<<<<<< HEAD
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
=======
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


@Entity(tableName = "page_response")
data class PageResponse(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "Page") @SerializedName("page") var page: Int,
    @ColumnInfo(name = "Per_Page") @SerializedName("per_page") var per_page: Int,
    @ColumnInfo(name = "Total") @SerializedName("total") var total: Int,
    @ColumnInfo(name = "Total_Page") @SerializedName("total_pages") var total_pages: Int,
    @TypeConverters(UserTypeConverters::class) @ColumnInfo(name = "Data") @SerializedName("data") var data: List<UserResponse>,
    @Embedded @SerializedName("support") var support: SupportResponse,
) {
    class UserTypeConverters {
        private var gson = Gson()

        @TypeConverter
        fun stringToSomeObjectList(data: String?): List<UserResponse> {
            if (data == null) {
                return Collections.emptyList()
            }
            val listType: Type = object : TypeToken<List<UserResponse?>?>() {}.type
            return gson.fromJson(data, listType)
        }

        @TypeConverter
        fun someObjectListToString(someObjects: List<UserResponse?>?): String {
            return gson.toJson(someObjects)
        }
    }

    class SupportTypeConverters {
        private var gson = Gson()

        @TypeConverter
        fun stringToSomeObjectList(data: String?): List<SupportResponse> {
            if (data == null) {
                return Collections.emptyList()
            }
            val listType: Type = object : TypeToken<List<SupportResponse?>?>() {}.type
            return gson.fromJson(data, listType)
        }

        @TypeConverter
        fun someObjectListToString(someObjects: List<SupportResponse?>?): String {
            return gson.toJson(someObjects)
        }
    }
}
>>>>>>> room-implementation
