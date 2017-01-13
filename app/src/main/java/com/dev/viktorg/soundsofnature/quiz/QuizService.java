package com.dev.viktorg.soundsofnature.quiz;

import android.content.Context;

import com.dev.viktorg.soundsofnature.model.Model;
import com.dev.viktorg.soundsofnature.model.ModelService;
import com.dev.viktorg.soundsofnature.service.DialogService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuizService {
    private int points = 0;
    private int id = 0;

    public Quiz getQuiz(Context current) {
        List<Model> models = ModelService.getModels(current, "Animals");
        List<Integer> imageIds = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();

        setIds(models, imageIds, ids, names, getImagesCount());
        setIds(models, imageIds, ids, names, getImagesCount() + 1);

        Collections.shuffle((List<?>) imageIds);
        Model answerModel = models.get(id);
        return new Quiz(imageIds, names, answerModel.getAudioIds(), answerModel.getImageId());
    }

    public void showSuccesfulDialog(Context context) {
        DialogService.showSuccesfulDialog(context);
    }

    public void showFailtureDialog(Context context, int rightId) {
        DialogService.showFailtureDialog(context, rightId);
    }

    public void addPoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    private int getImagesCount() {
        return (int) Math.ceil((double) ((points) / 5)) + 1;
    }

    private void setIds(List<Model> models, List<Integer> imageIds, Set<Integer> ids, List<String> names,
                        int size) {
        Random rand = new Random();

        while (imageIds.size() < size) {
            id = rand.nextInt(models.size());

            if (!ids.contains(id)) {
                add(models, imageIds, names, id);
                ids.add(id);
            }
        }
    }

    private void add(List<Model> entities, List<Integer> imageIds, List<String> names, int id) {
        imageIds.add(entities.get(id).getImageId());
        names.add(entities.get(id).getName());
    }
}
