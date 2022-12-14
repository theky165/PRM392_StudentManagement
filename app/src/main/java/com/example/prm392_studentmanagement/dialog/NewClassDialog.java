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
import com.example.prm392_studentmanagement.sqlite.ClassesDAO;

public class NewClassDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private EditText etClassId, etName;

    public NewClassDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_new_class);

        etClassId = findViewById(R.id.etClassId);
        etName = findViewById(R.id.etName);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnClose).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                Classes cls = new Classes();
                cls.setName(etName.getText().toString());
                ClassesDAO classesDAO = new ClassesDAO(context);
                classesDAO.insert(cls);
                Toast.makeText(context, "Class saved successful!", Toast.LENGTH_SHORT).show();

                dismiss();
                break;
            case R.id.btnClose:
                dismiss();
                break;
        }
    }
}
