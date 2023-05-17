package com.example.myapplication.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.Entity.StudentGuruh
import com.example.myapplication.Entity.Subject

@Dao
interface StudentGuruhDao {


    @Insert
    fun addStudentGuruh(studentGuruh: StudentGuruh)

    @Delete
    fun deleteStudentGuruh(studentGuruh: StudentGuruh)




}