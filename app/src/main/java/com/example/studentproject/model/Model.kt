package com.example.studentproject.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class Student(
//    var id:String,
//    var name:String,
//    var bod:String,
//    var phone:String,
//    var photoUrl:String

val id:String?,
@SerializedName("student_name")
val name:String?,
@SerializedName("birth_of_date")
val bod:String?,
val phone:String?,
@SerializedName("photo_url")
val photoUrl:String
):Serializable

