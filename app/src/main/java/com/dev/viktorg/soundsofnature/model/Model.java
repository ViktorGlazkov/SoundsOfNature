package com.dev.viktorg.soundsofnature.model;

import android.content.Context;

import com.dev.viktorg.soundsofnature.R;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int imageId;
    private Context context;
    private String name;
    private List<Integer> audioIds;

    public Model(Context current, String name) {
        this.context = current;
        this.name = name;
        this.imageId = context.getResources().getIdentifier(this.name,
                current.getString(R.string.drawable), context.getPackageName());
        setAudioIds();
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public List<Integer> getAudioIds() {
        return audioIds;
    }

    private void setAudioIds() {
        audioIds = new ArrayList<>();
        int id = context.getResources().getIdentifier(name, context.getString(R.string.raw),
                context.getPackageName());

        if (id != 0) {
            audioIds.add(id);

        } else {
            Integer i = 1;
            id = getId(i);

            while (id != 0) {
                audioIds.add(id);
                i++;
                id = getId(i);
            }
        }
    }

    private int getId(Integer i) {
        return context.getResources().getIdentifier(name + "_" + i.toString(), "raw",
                context.getPackageName());
    }
}
