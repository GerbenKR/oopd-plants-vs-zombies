package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.spawners.PeaSpawner;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

import java.util.ArrayList;
import java.util.List;

public class Repeater extends Plant {
    private FirstLevel level;
    private EntitySpawner spawner;

    public Repeater(Coordinate2D location, FirstLevel level) {
        super(location, Config.REPEATER_RESOURCE, Config.REPEATER_HEALTH, Config.SUNFLOWER_COST, Config.REPEATER_ID);
        this.level = level;
        doAction();
    }

    @Override
    public void doAction() {
        level.addEntitySpawner(new PeaSpawner(location, 1250));
        this.spawner = this.level.getSpawners().getLast();
    }

    @Override
    public void onCollision(List<Collider> list) {
        if(this.health <= 0) {
            remove();
            level.getSpawners().remove(spawner);
        }

        for (Collider collider : list) {
            if (collider instanceof Zombie) {
                this.health -= ((Zombie) collider).getDamage();
            }
        }
    }
}
