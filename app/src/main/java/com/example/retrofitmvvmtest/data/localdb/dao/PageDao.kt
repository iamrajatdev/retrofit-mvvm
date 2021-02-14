package com.example.retrofitmvvmtest.data.localdb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitmvvmtest.model.response.PageResponse

@Dao
interface PageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pages: PageResponse)

    @Query("Select * from page_response")
    fun fetchAllDataFromPages(): LiveData<PageResponse>

    @Query("DELETE  FROM page_response")
    suspend fun deletePage()
}