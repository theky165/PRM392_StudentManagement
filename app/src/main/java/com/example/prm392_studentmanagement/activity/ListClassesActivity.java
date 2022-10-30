package com.example.prm392_studentmanagement.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.prm392_studentmanagement.R;
import com.example.prm392_studentmanagement.adapter.ClassesAdapter;
import com.example.prm392_studentmanagement.model.Classes;
import com.example.prm392_studentmanagement.sqlite.ClassesDAO;

import java.util.List;

public class ListClassesActivity extends AppCompatActivity {
    private ListView lvClasses;
    private List<Classes> list;
    private ClassesAdapter clsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_classes);

        lvClasses = findViewById(R.id.lvClasses);

        fillClassListView();

        lvClasses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClassesDAO dao = new ClassesDAO(ListClassesActivity.this);
                Classes cls = list.get(i);
                dao.delete("" + cls.getId());

                return false;
            }
        });
    }

    private void fillClassListView() {
        ClassesDAO dao = new ClassesDAO(this);
        list = dao.getAll();

        clsAdapter = new ClassesAdapter(this, list);
        lvClasses.setAdapter(clsAdapter);
    }
}