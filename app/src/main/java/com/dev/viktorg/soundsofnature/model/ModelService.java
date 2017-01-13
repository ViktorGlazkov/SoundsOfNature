package com.dev.viktorg.soundsofnature.model;

import android.content.Context;
import android.content.res.Resources;

import com.dev.viktorg.soundsofnature.R;

import java.util.ArrayList;
import java.util.List;

public class ModelService {
    public static List<Model> getModels(Context context, String type) {
        Resources res = context.getResources();
        return type.equals(res.getString(R.string.animals)) ?
                getEModels(context, res.getStringArray(R.array.animals)) :
                getEModels(context, res.getStringArray(R.array.transport));
    }

    private static List<Model> getEModels(Context current, String[] names) {
        List<Model> entities = new ArrayList<>();

        for (String transport : names) {
            entities.add(new Model(current, transport));
        }

        return entities;
    }
}
