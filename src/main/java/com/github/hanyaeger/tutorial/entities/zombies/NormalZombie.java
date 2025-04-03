package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.plants.Plant;
import com.github.hanyaeger.tutorial.scenes.FirstLevelScene;

import java.util.List;

public class NormalZombie extends Zombie {

    public NormalZombie(PVZ pvz, FirstLevelScene firstLevelScene, Coordinate2D location) {
        super(pvz, firstLevelScene, location, "sprites/zombie.gif", 200, 0.1, 100);
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
