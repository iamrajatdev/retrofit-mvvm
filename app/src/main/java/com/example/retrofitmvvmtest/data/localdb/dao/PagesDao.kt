package com.example.retrofitmvvmtest.data.localdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitmvvmtest.model.response.PageResponse
import com.example.retrofitmvvmtest.model.response.UserResponse

@Dao
interface PagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(pages: List<PageResponse>)

    @Query("Select * from page_response")
    fun fetchDetails(): LiveData<List<PageResponse>>

}