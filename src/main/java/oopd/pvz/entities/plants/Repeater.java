package oopd.pvz.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import oopd.pvz.config.Config;
import oopd.pvz.entities.spawners.PeaSpawner;
import oopd.pvz.entities.zombies.Zombie;
import oopd.pvz.scenes.FirstLevelScene;

import java.util.List;

public class Repeater extends Plant {
    private final FirstLevelScene level;

    private EntitySpawner spawner;

    public Repeater(Coordinate2D location, FirstLevelScene level) {
        super(location, Config.REPEATER_RESOURCE, Config.REPEATER_HEALTH, Config.SUNFLOWER_COST, Config.REPEATER_ID);
        this.level = level;
        doAction();
    }

    @Override
    public void doAction() {
        // Add a spawner so the repeater shoots peas (twice as fast as the peashooter)
        level.addEntitySpawner(new PeaSpawner(location, 1250));
        this.spawner = this.level.getSpawners().getLast();
    }

    @Override
    public void onCollision(List<Collider> list) {
        if(this.getHealth() <= 0) {
            // delete the plant object, but also the pea spawner so it doesnt launch peas and make sure the tile can be used again.
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
