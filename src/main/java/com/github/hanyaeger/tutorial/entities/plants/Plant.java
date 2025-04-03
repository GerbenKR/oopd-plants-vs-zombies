package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Plant extends SpriteEntity implements Collider, Collided {
    protected int id;
    protected int health;
    protected int cost;
    protected Coordinate2D location;

    public Plant(Coordinate2D initialLocation, String resource, int health, int cost, int id) {
        super(resource, initialLocation, new Size(50, 50));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        this.location = initialLocation;
        this.health = health;
        this.cost = cost;
        this.id = 0;
    }

    public abstract void doAction();

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public int getCost() {
        return this.cost;
    }

    public Coordinate2D getLocation() {
        return this.location;
    }
}
