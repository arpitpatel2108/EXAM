package com.example.exam

data class Emp (var Emp_name:String,var Emp_gender:String,var Emp_age:Int ) {
    var id:Int=0
    constructor(id:Int,Emp_name:String,Emp_gender:String,Emp_age:Int):this(Emp_name,Emp_gender,Emp_age)
    {
        this.id=id
    }
}