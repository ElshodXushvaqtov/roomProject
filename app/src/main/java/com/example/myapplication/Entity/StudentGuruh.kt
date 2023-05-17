package com.example.myapplication.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity( tableName = "student_guruh",
    foreignKeys = [

        ForeignKey(
            entity = Guruh::class,
            parentColumns = ["guruh_id"],
            childColumns = ["guruh"]
        ),


    ]

)

data class StudentGuruh(
    @PrimaryKey(autoGenerate = true) var studentGuruh_id: Int,
    var guruh: Int
)
