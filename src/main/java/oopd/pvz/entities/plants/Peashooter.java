package oopd.pvz.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.EntitySpawner;
import oopd.pvz.config.Config;
import oopd.pvz.entities.spawners.PeaSpawner;
import oopd.pvz.entities.zombies.Zombie;
import oopd.pvz.scenes.FirstLevelScene;

import java.util.List;

public class Peashooter extends Plant {
    private final FirstLevelScene level;

    private EntitySpawner spawner;

    public Peashooter(Coordinate2D location, FirstLevelScene level) {
        super(location, Config.PEASHOOTER_RESOURCE, Config.PEASHOOTER_HEALTH, Config.SUNFLOWER_COST, Config.PEASHOOTER_ID);
        this.level = level;
        doAction();
    }

    @Override
    public void doAction() {
        level.addEntitySpawner(new PeaSpawner(location, 2500));
        this.spawner = this.level.getSpawners().getLast();
    }

    @Override
    public void onCollision(List<Collider> list) {
        if (this.getHealth() <= 0) {
            remove();
            this.level.getSpawners().remove(spawner);
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
