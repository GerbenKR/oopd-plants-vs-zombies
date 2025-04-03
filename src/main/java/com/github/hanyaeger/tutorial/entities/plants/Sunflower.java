package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.entities.spawners.SunSpawner;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

import java.util.List;


public class Sunflower extends Plant {
    private SunManager manager;
    private FirstLevel level;
    private EntitySpawner spawner;

    public Sunflower(Coordinate2D location, SunManager manager, FirstLevel level) {
        super(location, Config.SUNFLOWER_RESOURCE, Config.SUNFLOWER_HEALTH, Config.SUNFLOWER_COST, Config.SUNFLOWER_ID);
        this.manager = manager;
        this.level = level;
        doAction();
    }

    @Override
    public void doAction() {
        level.addEntitySpawner(new SunSpawner(this.manager, location));
        this.spawner = level.getSpawners().getLast();
    }

    @Override
    public void onCollision(List<Collider> list) {
        if(this.getHealth() <= 0) {
            remove();
            level.getSpawners().remove(spawner);
        }

        for (Collider collider : list) {
            if (collider instanceof Zombie) {
                this.setHealth(this.getHealth() - ((Zombie) collider).getDamage());
            }
        }
    }
}
