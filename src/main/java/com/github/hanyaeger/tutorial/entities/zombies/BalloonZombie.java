package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;

public class BalloonZombie extends Zombie {

    public BalloonZombie(Coordinate2D location) {
        super(location, "sprites/balloon-zombie.gif", 100, 1, 10);
    }

}
