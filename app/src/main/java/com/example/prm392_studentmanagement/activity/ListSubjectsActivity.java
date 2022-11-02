package com.example.prm392_studentmanagement.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_studentmanagement.R;
import com.example.prm392_studentmanagement.adapter.ClassesAdapter;
import com.example.prm392_studentmanagement.adapter.SubjectsAdapter;
import com.example.prm392_studentmanagement.model.Classes;
import com.example.prm392_studentmanagement.model.Subjects;
import com.example.prm392_studentmanagement.sqlite.ClassesDAO;
import com.example.prm392_studentmanagement.sqlite.SubjectDAO;

import java.util.List;

public class ListSubjectsActivity extends AppCompatActivity {
    private ListView lvSubjects;
    private List<Subjects> list;
    private SubjectsAdapter clsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_subjects);

        lvSubjects = findViewById(R.id.lvSubjects);

        fillSubjectListView();

        lvSubjects.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SubjectDAO dao = new SubjectDAO(ListSubjectsActivity.this);
                Subjects cls = list.get(i);
                dao.delete("" + cls.getId());

                return false;
            }
        });
    }

    private void fillSubjectListView() {
        SubjectDAO dao = new SubjectDAO(this);
        list = dao.getAll();

        clsAdapter = new SubjectsAdapter(this, list);
        lvSubjects.setAdapter(clsAdapter);
    }
}