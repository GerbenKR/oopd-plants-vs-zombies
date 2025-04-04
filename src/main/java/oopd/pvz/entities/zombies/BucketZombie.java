package oopd.pvz.entities.zombies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import oopd.pvz.PVZ;
import oopd.pvz.entities.plants.Plant;
import oopd.pvz.scenes.FirstLevelScene;

import java.util.List;

public class BucketZombie extends Zombie {

    public BucketZombie(PVZ pvz, FirstLevelScene firstLevelScene, Coordinate2D location) {
        super(pvz, firstLevelScene, location, "sprites/bucket-zombie.gif", 650, 0.1, 100);
    }

    @Override
    public void onCollision(List<Collider> list) {
        if (this.getHealth() <= 0) {
            remove();
        }

        for (Collider collider : list) {
            if (collider instanceof Plant) {
                setMotion(0, Direction.LEFT);
            }
        }
    }

}
