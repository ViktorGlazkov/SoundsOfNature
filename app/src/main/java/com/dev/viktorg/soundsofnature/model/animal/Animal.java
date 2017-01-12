package com.dev.viktorg.soundsofnature.model.animal;

import android.content.Context;

import com.dev.viktorg.soundsofnature.model.Entity;

public class Animal extends Entity {
    public Animal(Context current, Animals animals) {
        super(current, animals.name());
    }
}
