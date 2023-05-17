package com.example.myapplication.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.myapplication.Entity.Marks

@Dao
interface MarksDao {

    @Insert
    fun addMarks(marks: Marks)

    @Delete
    fun deleteMarks(marks: Marks)

}