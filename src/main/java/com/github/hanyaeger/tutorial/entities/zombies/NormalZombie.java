package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;

public class NormalZombie extends Zombie {

    public NormalZombie(Coordinate2D location) {
        super(location, "sprites/zombie.gif", 100, 1, 10);
    }

}
