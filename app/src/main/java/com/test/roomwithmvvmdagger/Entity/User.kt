package com.test.roomwithmvvmdagger.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User constructor(val name:String, val address:String,val phoneNo : String,val email : String) {
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}