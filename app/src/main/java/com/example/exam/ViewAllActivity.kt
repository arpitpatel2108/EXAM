package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        var db = DBHelper(this)
        var arr=db.retriveall()
        var adapter=EmpAdaptor(this,arr)
        myrecycle.adapter=adapter
    }
}