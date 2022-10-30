package com.example.prm392_studentmanagement.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prm392_studentmanagement.R;
import com.example.prm392_studentmanagement.adapter.ClassesAdapter;
import com.example.prm392_studentmanagement.helper.DateTimeHelper;
import com.example.prm392_studentmanagement.model.Classes;
import com.example.prm392_studentmanagement.model.Student;
import com.example.prm392_studentmanagement.sqlite.ClassesDAO;
import com.example.prm392_studentmanagement.sqlite.StudentDAO;
import com.google.android.material.snackbar.Snackbar;

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

        fillClassesToSpinner();

        findViewById(R.id.btnSave).setOnClickListener(this);

    }
    private  void fillClassesToSpinner(){
        ClassesDAO classesDAO = new ClassesDAO(this);
        classesList = classesDAO.getAll();
        ClassesAdapter classesAdapter = new ClassesAdapter(this,classesList);
        spClasses.setAdapter(classesAdapter);

    }

    @Override
    public void onClick(View view) {
        StudentDAO studentDAO = new StudentDAO(this);
        switch (view.getId()){
            case  R.id.btnSave:
                try {
                    Student std = new Student();
                    std.setId(etStudentId.getText().toString());
                    std.setName(etStudentId.getText().toString());
                    std.setDob(DateTimeHelper.toDate(etDob.getText().toString()));

                    Classes cls = (Classes) spClasses.getSelectedItem();
                    std.setClassId(cls.getId());
                    String msg;
                    studentDAO.insert(std);
                    msg = "Student has save!";

                    Snackbar snackbar = Snackbar.make(view,msg,Snackbar.LENGTH_LONG);
                    snackbar.show();
                    etStudentId.setText("");
                    etName.setText("");
                    etDob.setText("");

                }catch (Exception ex){
                    ex.printStackTrace();
                    Toast.makeText(this,"Erroe: "+ ex.getMessage(),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}