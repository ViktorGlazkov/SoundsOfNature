package com.dev.viktorg.soundsofnature.model;


import java.util.ArrayList;
import java.util.List;

public class EntityList {
    private List<Entity> entityList;
    private List<String> names;
    private List<Integer> imageIds;

    public EntityList(List<Entity> entityList) {
        this.entityList = entityList;
        setValues();
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getImageIds() {

        return imageIds;
    }

    public int size() {
        return entityList.size();
    }

    public Entity get(int i) {
        return entityList.get(i);
    }

    private void setValues() {
        names = new ArrayList<>();
        imageIds = new ArrayList<>();
        for(Entity entity: entityList) {
            names.add(entity.getName());
            imageIds.add(entity.getImageId());
        }
    }
}
