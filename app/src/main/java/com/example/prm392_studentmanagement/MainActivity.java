package com.example.prm392_studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prm392_studentmanagement.activity.ListClassesActivity;
import com.example.prm392_studentmanagement.activity.ManageStudentActivity;
import com.example.prm392_studentmanagement.dialog.NewClassDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnNewClass).setOnClickListener(this);
        findViewById(R.id.btnClasses).setOnClickListener(this);
        findViewById(R.id.btnManagementStudent).setOnClickListener(this);
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
                Intent intent = new Intent(this, ListClassesActivity.class);
                startActivity(intent);
                break;
            case R.id.btnManagementStudent:
                Intent mgnIntent = new Intent(this, ManageStudentActivity.class);
                startActivity(mgnIntent);
                break;
            case R.id.btnLogout:
                break;
        }
    }
}