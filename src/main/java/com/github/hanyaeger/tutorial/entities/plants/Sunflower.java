package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.core.entities.EntityCollection;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.entities.spawners.SunSpawner;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;


public class Sunflower extends Plant {
    private SunManager manager;

    public Sunflower(Coordinate2D location, SunManager manager, FirstLevel level) {
        super(location, Config.SUNFLOWER_HEALTH, Config.SUNFLOWER_COST, Config.SUNFLOWER_ID);
        this.manager = manager;
        doAction();

        level.addEntitySpawner(new SunSpawner(this.manager));
    }

    @Override
    protected void setupEntities() {
        addEntity(new SunflowerSprite("sprites/sunflower.gif", new Coordinate2D(0, 0)));
    }

    @Override
    public void doAction() {

    }
}
