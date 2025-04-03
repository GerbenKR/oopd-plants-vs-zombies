package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;

import java.util.List;

public class Walnut extends Plant {
    public Walnut(Coordinate2D initialLocation) {
        super(initialLocation, Config.WALNUT_RESOURCE, Config.WALNUT_HEALTH, Config.WALNUT_COST, Config.WALNUT_ID);
    }

    @Override
    public void doAction() {
        // Niks
    }

    @Override
    public void onCollision(List<Collider> list) {
        if(this.health <= 0) {
            remove();
        }

        for (Collider collider : list) {
            if (collider instanceof Zombie) {
                this.health -= ((Zombie) collider).getDamage();
            }
        }
    }
}
