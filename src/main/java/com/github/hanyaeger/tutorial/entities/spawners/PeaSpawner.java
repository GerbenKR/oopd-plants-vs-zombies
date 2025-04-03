package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.items.Pea;

public class PeaSpawner extends EntitySpawner {
    private final Coordinate2D location;

    public PeaSpawner(Coordinate2D location, long interval) {
        super(interval);
        this.location = location;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Pea(location));
    }
}
