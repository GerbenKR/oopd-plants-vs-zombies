package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.core.entities.EntityCollection;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.google.inject.Injector;

import java.util.List;


public class Sunflower extends Plant {
    private SunManager manager;

    public Sunflower(Coordinate2D location, SunManager manager) {
        super(location, Config.SUNFLOWER_HEALTH, Config.SUNFLOWER_COST, Config.SUNFLOWER_ID);
        this.manager = manager;
        doAction();
    }

    @Override
    protected void setupEntities() {
        addEntity(new SunflowerSprite("sprites/sunflower.gif", new Coordinate2D(0, 0)));
    }

    @Override
    public void doAction() {

    }

    @Override
    public void setupEntitySpawners() {
        
    }

    @Override
    public Injector getInjector() {
        return null;
    }

    @Override
    public EntityCollection getEntityCollection() {
        return null;
    }

    @Override
    public List<EntitySpawner> getSpawners() {
        return List.of();
    }
}
