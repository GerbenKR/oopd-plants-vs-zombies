package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

import java.util.List;

public class Walnut extends Plant {
    private FirstLevel level;

    public Walnut(Coordinate2D initialLocation, FirstLevel level) {
        super(initialLocation, Config.WALNUT_RESOURCE, Config.WALNUT_HEALTH, Config.WALNUT_COST, Config.WALNUT_ID);
        this.level = level;
    }

    @Override
    public void doAction() {
        // Niks
    }

    @Override
    public void onCollision(List<Collider> list) {
        if(this.getHealth() <= 0) {
            remove();
            this.level.getPlants().remove(this);
        }

        for (Collider collider : list) {
            if (collider instanceof Zombie) {
                this.setHealth(this.getHealth() - ((Zombie) collider).getDamage());
            }
        }
    }
}
