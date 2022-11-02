package com.example.prm392_studentmanagement.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.prm392_studentmanagement.R;
import com.example.prm392_studentmanagement.model.Classes;
import com.example.prm392_studentmanagement.model.Subjects;
import com.example.prm392_studentmanagement.sqlite.ClassesDAO;
import com.example.prm392_studentmanagement.sqlite.SubjectDAO;

public class NewSubjectDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private EditText etSubjectId, etName;

    public NewSubjectDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_new_subject);

        etName = findViewById(R.id.etName);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnClose).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                Subjects cls = new Subjects();
                cls.setName(etName.getText().toString());
                SubjectDAO subjectDAO = new SubjectDAO(context);
                subjectDAO.insert(cls);
                Toast.makeText(context, "Subject saved successful!", Toast.LENGTH_SHORT).show();

                dismiss();
                break;
            case R.id.btnClose:
                dismiss();
                break;
        }
    }
}
