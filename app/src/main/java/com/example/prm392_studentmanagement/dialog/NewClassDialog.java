package com.example.prm392_studentmanagement.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.prm392_studentmanagement.R;

public class NewClassDialog extends Dialog implements View.OnClickListener {
    private Context context;
    public NewClassDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_new_class);
    }

    @Override
    public void onClick(View view) {

    }
}
