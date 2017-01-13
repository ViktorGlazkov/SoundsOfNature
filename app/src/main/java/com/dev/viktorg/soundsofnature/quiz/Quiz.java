package com.dev.viktorg.soundsofnature.quiz;

import java.util.List;

public class Quiz {
    private List<Integer> imageIds;
    private List<Integer> audioIds;
    private List<String> names;
    private int trueImageId;

    public Quiz(List<Integer> imageIds, List<String> names, List<Integer> audioIds, int trueImageId) {
        this.imageIds = imageIds;
        this.audioIds = audioIds;
        this.names = names;
        this.trueImageId = trueImageId;
    }

    public List<Integer> getImageIds() {
        return imageIds;
    }

    public int getAudioId() {
        return audioIds.get(0);
    }

    public int getTrueImageId() {
        return trueImageId;
    }

    public List<String> getNames() {
        return names;
    }

}
