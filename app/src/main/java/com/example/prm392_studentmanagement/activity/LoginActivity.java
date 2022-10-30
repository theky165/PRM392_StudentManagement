package com.example.prm392_studentmanagement.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.prm392_studentmanagement.MainActivity;
import com.example.prm392_studentmanagement.R;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {
    EditText etUser,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.prm392_studentmanagement.R.layout.activity_login);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPass);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                if (etUser.getText().toString().equals("admin")
                        && etPassword.getText().toString().equals("123"))
                {
                    Intent intent =  new Intent(this, MainActivity.class);
                    startActivity(intent);
                }else
                {
                    Snackbar.make(view,"Wrong UserName or Password!",Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.btnExit:
                finish();
                break;
        }

    }
}