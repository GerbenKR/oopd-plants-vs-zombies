package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;

public class BucketZombie extends Zombie {

    public BucketZombie(Coordinate2D location) {
        super(location, "sprites/bucket-zombie.gif", 650, 0.3, 100);
    }

}
