package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.spawners.PeaSpawner;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

public class Peashooter extends Plant {
    public Peashooter(Coordinate2D location, FirstLevel level) {
        super(location, Config.PEASHOOTER_HEALTH, Config.SUNFLOWER_COST, Config.PEASHOOTER_ID);
        level.addEntitySpawner(new PeaSpawner(location));
    }

    @Override
    protected void setupEntities() {
        addEntity(new PeashooterSprite("sprites/peashooter.gif", new Coordinate2D(0, 0)));
    }

    @Override
    public void doAction() {
        System.out.println("Peashooter");
    }
}
