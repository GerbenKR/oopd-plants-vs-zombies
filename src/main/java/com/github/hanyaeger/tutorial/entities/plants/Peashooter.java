package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.config.Config;

public class Peashooter extends Plant {
    public Peashooter(Coordinate2D location) {
        super(location, Config.PEASHOOTER_HEALTH, Config.SUNFLOWER_COST, Config.PEASHOOTER_ID);
    }

    @Override
    protected void setupEntities() {
        addEntity(new PeashooterSprite("sprites/peashooter.gif", new Coordinate2D(0, 0)));
    }
}
