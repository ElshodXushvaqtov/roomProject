package com.example.myapplication.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
  @PrimaryKey(autoGenerate = true)
  var user_id: Int = 0,
  @ColumnInfo(name = "username")
  var userName: String,
  var login: String,
  var password: String,
  var role: String
)