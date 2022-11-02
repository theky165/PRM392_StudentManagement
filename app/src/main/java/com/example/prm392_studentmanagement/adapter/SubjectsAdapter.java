package com.example.prm392_studentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prm392_studentmanagement.R;
import com.example.prm392_studentmanagement.model.Subjects;

import java.util.List;

public class SubjectsAdapter extends BaseAdapter {
    private Context context;
    private List<Subjects> list;

    public SubjectsAdapter(Context context, List<Subjects> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_subjects_item, null);
        }

        TextView tvId = view.findViewById(R.id.tvSubjectId);
        TextView tvName = view.findViewById(R.id.tvName);

        Subjects cls = list.get(i);
        tvId.setText("" + cls.getId());
        tvName.setText(cls.getName());
        return view;
    }
}
