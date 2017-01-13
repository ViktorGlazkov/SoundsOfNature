package com.dev.viktorg.soundsofnature.service;

import android.app.Activity;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dev.viktorg.soundsofnature.adapter.CustomListAdapter;

import java.util.List;

public class ListViewService {
    public static void setListView(Context context, List<String> names, List<Integer> imageIds,
                                   int viewId, AdapterView.OnItemClickListener onItemClickListener) {
        CustomListAdapter adapter = new CustomListAdapter((Activity) context, names, imageIds);
        ListView listView = (ListView) (((Activity) context).findViewById(viewId));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClickListener);
    }
}
