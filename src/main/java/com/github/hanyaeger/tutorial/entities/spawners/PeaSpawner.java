package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.entities.items.Pea;

public class PeaSpawner extends EntitySpawner {
    private Coordinate2D location;

    public PeaSpawner(Coordinate2D location) {
        super(2500);
        this.location = location;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Pea(location));
    }
}
