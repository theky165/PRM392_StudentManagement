package com.example.prm392_studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.prm392_studentmanagement.dialog.NewClassDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnNewClass).setOnClickListener(this);
        findViewById(R.id.btnClasses).setOnClickListener(this);
        findViewById(R.id.btnListStudents).setOnClickListener(this);
        findViewById(R.id.btnLogout).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNewClass:
                NewClassDialog dialog = new NewClassDialog(this);
                dialog.show();
                break;
            case R.id.btnClasses:
                break;
            case R.id.btnListStudents:
                break;
            case R.id.btnLogout:
                break;
        }
    }
}