package com.dev.viktorg.soundsofnature.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.dev.viktorg.soundsofnature.R;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<Integer> imgid;

    public CustomListAdapter(Activity context, List<String> names, List<Integer> imgid) {
        super(context, R.layout.mylist, names);

        this.context = context;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        imageView.setImageResource(imgid.get(position));

        return rowView;
    }
}

