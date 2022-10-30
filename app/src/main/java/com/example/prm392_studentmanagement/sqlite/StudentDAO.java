package com.example.prm392_studentmanagement.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.prm392_studentmanagement.helper.DateTimeHelper;
import com.example.prm392_studentmanagement.model.Student;

public class StudentDAO {
    private SQLiteDatabase db;

    public StudentDAO(Context context) {
        DbHelper helper = new DbHelper(context);

        this.db =  helper.getWritableDatabase();
    }

    public long insert(Student emp){
        ContentValues values = new ContentValues();
        values.put("id",emp.getId());
        values.put("name",emp.getName());
        values.put("dob", DateTimeHelper.toString(emp.getDob()));
        values.put("classid",emp.getClassId());
        return db.insert("students",null,values);
    }
}
