package com.example.prm392_studentmanagement.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.prm392_studentmanagement.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
    private SQLiteDatabase db;

    public SubjectDAO(Context context) {
        DbHelper helper = new DbHelper(context);
        this.db =  helper.getWritableDatabase();
    }
    public long insert(Subjects emp){
        ContentValues values = new ContentValues();
        values.put("id",emp.getId());
        values.put("name",emp.getName());
        return db.insert("subjects",null,values);
    }

    @SuppressLint("Range")
    public List<Subjects> get(String sql, String ... selectArgs){
        List<Subjects> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()) {
            Subjects cls = new Subjects();
            cls.setId(cursor.getInt(cursor.getColumnIndex("id")));
            cls.setName(cursor.getString(cursor.getColumnIndex("name")));
            list.add(cls);
        }
        return list;
    }

    public List<Subjects> getAll(){
        String sql = "SELECT * FROM subjects";
        return get(sql);
    }

    public int delete(String id){
        return db.delete("subjects", "id=?", new String[]{id});
    }
}

