package oopd.pvz.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import oopd.pvz.config.Config;
import oopd.pvz.entities.managers.SunManager;
import oopd.pvz.entities.spawners.SunSpawner;
import oopd.pvz.entities.zombies.Zombie;
import oopd.pvz.scenes.FirstLevelScene;

import java.util.List;

public class Sunflower extends Plant {
    private final SunManager manager;
    private final FirstLevelScene level;

    private EntitySpawner spawner;

    public Sunflower(Coordinate2D location, SunManager manager, FirstLevelScene level) {
        super(location, Config.SUNFLOWER_RESOURCE, Config.SUNFLOWER_HEALTH, Config.SUNFLOWER_COST, Config.SUNFLOWER_ID);
        this.manager = manager;
        this.level = level;
        doAction();
    }

    @Override
    public void doAction() {
        // Add a spawner so the sunflower generate suns
        level.addEntitySpawner(new SunSpawner(this.manager, location));
        this.spawner = level.getSpawners().getLast();
    }

    @Override
    public void onCollision(List<Collider> list) {
        if(this.getHealth() <= 0) {
            // delete the plant object, but also the sun spawner so it doesnt generate suns and make sure the tile can be used again.
            remove();
            level.getSpawners().remove(spawner);
            this.level.getPlants().remove(this);
        }

        for (Collider collider : list) {
            if (collider instanceof Zombie) {
                this.setHealth(this.getHealth() - ((Zombie) collider).getDamage());

                if (this.health <= 0) {
                    ((Zombie) collider).startWalking();
                }
            }
        }
    }
}
