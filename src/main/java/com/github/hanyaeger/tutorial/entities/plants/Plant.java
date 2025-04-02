package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Plant extends DynamicSpriteEntity {
    protected int id;
    protected double health;
    protected int cost;
    protected Coordinate2D location;
    protected String resource;

    public Plant(String resource, Coordinate2D initialLocation, double health, int cost, int id) {
        super(resource, initialLocation, new Size(50, 50));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.resource = resource;
        this.location = initialLocation;
        this.health = health;
        this.cost = cost;
        this.id = 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getHealth() {
        return this.health;
    }

    public int getCost() {
        return this.cost;
    }

    public Coordinate2D getLocation() {
        return this.location;
    }
}
