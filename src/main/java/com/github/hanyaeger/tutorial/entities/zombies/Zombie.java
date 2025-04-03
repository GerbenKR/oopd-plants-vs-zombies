package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Zombie extends DynamicSpriteEntity implements Collided, Collider {
    private Coordinate2D location;
    private int health;
    private double speed;
    private int damage;

    public Zombie(Coordinate2D location, String image, int health, double speed, int damage) {
        super(image, location, new Size(50,77));
        setMotion(speed, Direction.LEFT);

        this.location = location;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
    }

    public void subtractHealth(int amount) {
        health -= amount;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
