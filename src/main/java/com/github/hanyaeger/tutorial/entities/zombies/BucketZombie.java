package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.plants.Plant;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

import java.util.List;

public class BucketZombie extends Zombie {

    public BucketZombie(PVZ pvz, FirstLevel firstLevel, Coordinate2D location) {
        super(pvz, firstLevel, location, "sprites/bucket-zombie.gif", 650, 0.1, 100);
    }

    @Override
    public void onCollision(List<Collider> list) {
        if (this.getHealth() <= 0) {
            remove();
        }

        for (Collider collider : list) {
            if (collider instanceof Plant) {
                setMotion(0, Direction.LEFT);
            }
        }
    }

}
