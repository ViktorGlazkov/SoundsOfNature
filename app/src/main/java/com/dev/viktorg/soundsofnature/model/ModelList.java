package com.dev.viktorg.soundsofnature.model;


import java.util.ArrayList;
import java.util.List;

public class ModelList {
    private List<Model> modelList;
    private List<String> names;
    private List<Integer> imageIds;

    public ModelList(List<Model> modelList) {
        this.modelList = modelList;
        setValues();
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getImageIds() {
        return imageIds;
    }

    public Model get(int i) {
        return modelList.get(i);
    }

    private void setValues() {
        names = new ArrayList<>();
        imageIds = new ArrayList<>();
        for (Model model : modelList) {
            names.add(model.getName());
            imageIds.add(model.getImageId());
        }
    }
}
