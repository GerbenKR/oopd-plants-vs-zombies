package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;

import java.util.Random;

public class SunSpawner extends EntitySpawner {
    private SunManager manager;

    public SunSpawner(SunManager manager) {
        super(5000);
        this.manager = manager;
    }

    @Override
    protected void spawnEntities(){
        spawn(new Sun(randomLocation(), this.manager));
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) 520) + 180;
        double y = new Random().nextInt((int) 355) + 55;
        return new Coordinate2D(x, y);
    }
}
