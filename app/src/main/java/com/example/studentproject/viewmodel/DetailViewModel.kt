package com.example.studentproject.viewmodel

import android.R
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.studentproject.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()

    val Tag: String="volley Tag"
    val errorLD = MutableLiveData<Boolean>()
    var queue: RequestQueue?=null

    fun fetch(id: String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://www.jsonkeeper.com/b/LLmW"
        errorLD.value=false
        val stringRequest = StringRequest(Request.Method.GET, url, {
            val sType = object: TypeToken<List<Student>>(){}.type
            val result = Gson().fromJson<List<Student>>(it, sType) as ArrayList
            val student = result.find { it.id == id } as Student
            studentLD.value = student
        },{
            Log.d("volley_status",
        it.message.toString())

        errorLD.value=true
        })
        stringRequest.tag = Tag
        queue?.add(stringRequest)
//        val student1 = Student(
//            "16055", "Nonie", "1998/03/28", "5718444778",
//            "http://dummyimage.com/75x100.jpg/cc0000/ffffff"
//        )
//        studentLD.value = studentLD
    }
}
