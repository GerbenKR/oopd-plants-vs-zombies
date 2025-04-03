package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;

import java.util.Random;

public class SunSpawner extends EntitySpawner {
    private final SunManager manager;
    private Coordinate2D location;

    public SunSpawner(SunManager manager) {
        super(5000);
        this.manager = manager;
    }

    public SunSpawner(SunManager manager, Coordinate2D location) {
        super(5000);
        this.manager = manager;
        this.location = location;
    }

    @Override
    protected void spawnEntities(){
        if (this.location != null) {
            spawn(new Sun(this.location, this.manager));
        } else {
            spawn(new Sun(randomLocation(), this.manager));
        }
    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) 520) + 180;
        double y = new Random().nextInt((int) 355) + 55;
        return new Coordinate2D(x, y);
    }
}
