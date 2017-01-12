package com.dev.viktorg.soundsofnature.model.entity;

import android.content.Context;

import com.dev.viktorg.soundsofnature.model.animal.Animal;
import com.dev.viktorg.soundsofnature.model.animal.Animals;
import com.dev.viktorg.soundsofnature.model.transport.Transport;
import com.dev.viktorg.soundsofnature.model.transport.Transports;

import java.util.ArrayList;
import java.util.List;

public class EntityService {
    public static List<Entity> getEntities(Context context, String type) {
        return type.equals("animal") ? getAnimals(context) : getTransport(context);
    }

    public static List<Entity> getAnimals(Context current) {
        Animals[] animals = Animals.values();
        List<Entity> animalList = new ArrayList<>();
        for(Animals animals1: animals) {
            animalList.add(new Animal(current, animals1));
        }
        return animalList;
    }

    public static List<Entity> getTransport(Context current) {
        Transports[] transports = Transports.values();
        List<Entity> transportList = new ArrayList<>();
        for(Transports transport: transports) {
            transportList.add(new Transport(current, transport));
        }
        return transportList;
    }
}
