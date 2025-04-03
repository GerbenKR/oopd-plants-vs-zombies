package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.scenes.FirstLevelScene;

public abstract class Zombie extends DynamicSpriteEntity implements Collided, Collider, SceneBorderTouchingWatcher {
    private final PVZ pvz;
    private final FirstLevelScene firstLevelScene;
    private final double speed;
    private final int damage;

    private int health;

    public Zombie(PVZ pvz, FirstLevelScene firstLevelScene, Coordinate2D location, String image, int health, double speed, int damage) {
        super(image, location, new Size(50,77));

        this.pvz = pvz;
        this.firstLevelScene = firstLevelScene;
        this.health = health;
        this.speed = speed;
        this.damage = damage;

        this.startWalking();
    }

    // When a zombie hits the (left) scene border, the game is over
    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        pvz.setActiveScene(2); // Game over screen
    }

    public void subtractHealth(int amount) {
        this.health -= amount;

        if (this.health <= 0) {
            remove();
            firstLevelScene.setZombieCount(firstLevelScene.getZombieCount() - 1);
        }

        // When the zombie count is 0 & we are in the final wave, then the user won
        if (firstLevelScene.getZombieCount() == 0 && firstLevelScene.isFinalWave()) {
            pvz.setActiveScene(3);
        }
    }

    public void startWalking() {
        setMotion(this.speed, Direction.LEFT);
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
}
