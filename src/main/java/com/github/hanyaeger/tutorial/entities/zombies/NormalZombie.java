package com.github.hanyaeger.tutorial.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;

public class NormalZombie extends Zombie {

    public NormalZombie(Coordinate2D location) {
        super(location, "sprites/zombie.gif", 200, 0.3, 100);
    }

}
