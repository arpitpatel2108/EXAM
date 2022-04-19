package com.example.exam

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (var context: Context): SQLiteOpenHelper(context, DB_NAME,null,DB_VERSION) {
    companion object{

        private var DB_NAME="Employeedb"
        private var DB_TABEL="Employee"
        private var DB_VERSION=1
        private var DB_PARSON="name"
        private var DB_GENDER="Gender"
        private var DB_AGE="age"
        private var DB_ID="ID"



    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $DB_TABEL ($DB_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",$DB_PARSON TEXT,$DB_GENDER TEXT,$DB_AGE INTEGER)"
        p0?.execSQL(query);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query="DROP TABLE $DB_TABEL IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)
    }
    fun insert(fruit: Emp):Boolean {
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(DB_PARSON,fruit.Emp_name)
        cv.put(DB_GENDER,fruit.Emp_gender)
        cv.put(DB_AGE,fruit.Emp_age)
        var flag= db.insert(DB_TABEL,null,cv)
        if (flag>0)
        {
            return true
        }
        else
        {
            return false
        }
    }
    fun retriveall():ArrayList<Emp>
    {
        var db =readableDatabase
        var cursor=db.query(DB_TABEL,null,null,null,null,null,null)
        var arr:ArrayList<Emp> = ArrayList()
        while (cursor.moveToNext())
        {
            var name=cursor.getString(1)
            var Gender=cursor.getString(2)
            var age=cursor.getInt(3)
            var id=cursor.getInt(0)
            var fruit=Emp(id,name,Gender,age)
            arr.add(fruit)


        }
        return arr


    }
}
