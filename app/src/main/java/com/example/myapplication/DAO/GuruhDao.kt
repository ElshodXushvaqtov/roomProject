package com.example.myapplication.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.Entity.Guruh

@Dao
interface GuruhDao {
    @Insert
    fun addGuruh(guruh: Guruh)

    @Delete
    fun deleteGuruh(guruh: Guruh)

    @Query("select * from guruhlar")
    fun getAllGuruh():List<Guruh>

    @Query("select * from guruhlar where guruh_id = :id")
    fun getGuruhById(id:Int): Guruh
}