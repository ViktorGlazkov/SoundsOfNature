package com.dev.viktorg.soundsofnature.model.entity;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    private Context context;
    private String name;
    private int imageId;
    private List<Integer> audioIds;

    public Entity(Context current, String name) {
        this.context = current;
        this.name = name;
        this.imageId = context.getResources().getIdentifier(this.name, "drawable",
                context.getPackageName());
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
        int id = context.getResources().getIdentifier(name, "raw", context.getPackageName());

        if (id != 0) {
            audioIds.add(id);

        } else {
            Integer i = 1;
            id = context.getResources().getIdentifier(name + "_" + i.toString(), "raw",
                    context.getPackageName());
            while(id != 0) {
                audioIds.add(id);
                i++;
                id = context.getResources().getIdentifier(name + "_" + i.toString(), "raw",
                        context.getPackageName());
            }
        }
    }
}
