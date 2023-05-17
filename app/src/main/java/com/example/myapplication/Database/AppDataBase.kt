package com.example.myapplication.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.DAO.*
import com.example.myapplication.Entity.*

@Database(entities = [User::class, Guruh::class, Marks::class, StudentGuruh::class, Subject::class, TeacherSubject::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
//teach1
    companion object{
        var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase{
            if(instance==null){
                instance = Room.databaseBuilder(context, AppDataBase::class.java, "app_db").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
   
}