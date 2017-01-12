package com.dev.viktorg.soundsofnature.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected Context context;
    protected String name;
    protected int imageId;
    protected List<Integer> audioIds;

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
        for (Integer i = 1; ; i++) {
            int id = context.getResources().getIdentifier(name, "raw", context.getPackageName());
            if (id != 0) {
                audioIds.add(id);
                break;
            }

            id = context.getResources().getIdentifier(name + "_" + i.toString(), "raw",
                    context.getPackageName());

            if (id == 0) {
                break;

            } else {
                audioIds.add(id);
            }
        }
    }
}
