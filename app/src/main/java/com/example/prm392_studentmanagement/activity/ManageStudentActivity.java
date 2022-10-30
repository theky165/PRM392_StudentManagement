package com.example.prm392_studentmanagement.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.prm392_studentmanagement.R;
import com.example.prm392_studentmanagement.model.Classes;
import com.example.prm392_studentmanagement.sqlite.ClassesDAO;

import java.util.List;

public class ManageStudentActivity extends AppCompatActivity implements View.OnClickListener  {
    private EditText etStudentId,etName,etDob;
    private Spinner spClasses;
    private List<Classes> classesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);
        etStudentId = findViewById(R.id.etStudentId);
        etName = findViewById(R.id.etName);
        etDob = findViewById(R.id.etDob);
        spClasses = findViewById(R.id.spClasses);

    }
    private  void fillClassesToSpinner(){
        ClassesDAO classesDAO = new ClassesDAO(this);
        classesList = classesDAO.getAll();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.btnSave:
                break;
        }
    }
}