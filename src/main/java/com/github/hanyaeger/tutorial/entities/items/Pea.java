package com.github.hanyaeger.tutorial.entities.items;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import javafx.scene.input.MouseButton;

import java.util.List;

public class Pea extends DynamicSpriteEntity implements Collided {
    public static final int DAMAGE = 25;

    public Pea(Coordinate2D location) {
        super("sprites/pea.png", location, new Size(20, 20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(2, 90);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Zombie) {
                ((Zombie) collider).subtractHealth(DAMAGE);
                remove();
            }
        }
    }
}
