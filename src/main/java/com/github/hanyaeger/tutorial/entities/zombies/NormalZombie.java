package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.tutorial.entities.plants.Plant;

import java.util.List;

public class NormalZombie extends Zombie {

    public NormalZombie(Coordinate2D location) {
        super(location, "sprites/zombie.gif", 200, 0.1, 100);
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
