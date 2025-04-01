package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Zombie extends DynamicSpriteEntity {

    private Coordinate2D location;
    private int health;
    private int speed;
    private int damage;

    public Zombie(Coordinate2D location, String image, int health, int speed, int damage) {
        super(image, location, new Size(50,77));

        this.location = location;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
    }

}
