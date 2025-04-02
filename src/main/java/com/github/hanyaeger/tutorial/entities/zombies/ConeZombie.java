package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;

public class ConeZombie extends Zombie {

    public ConeZombie(Coordinate2D location) {
        super(location, "sprites/cone-zombie.gif", 280, 0.3, 100);
    }

}

