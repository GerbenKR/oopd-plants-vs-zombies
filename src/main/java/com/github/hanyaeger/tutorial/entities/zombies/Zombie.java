package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

public abstract class Zombie extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher {
    private PVZ pvz;
    private FirstLevel firstLevel;
    private Coordinate2D location;
    private int health;
    private double speed;
    private int damage;

    public Zombie(PVZ pvz, FirstLevel firstLevel, Coordinate2D location, String image, int health, double speed, int damage) {
        super(image, location, new Size(50,77));

        setMotion(speed, Direction.LEFT);

        this.pvz = pvz;
        this.firstLevel = firstLevel;
        this.location = location;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
    }

    // When a zombie hits the (left) scene border, the game is over
    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        pvz.setActiveScene(2); //Game over screen
    }

    public void subtractHealth(int amount) {
        this.health -= amount;

        if (this.health <= 0) {
            remove();
            firstLevel.setZombieCount(firstLevel.getZombieCount() - 1);

            System.out.println("Killed");
            System.out.println("Zombie count: " + firstLevel.getZombieCount());
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
