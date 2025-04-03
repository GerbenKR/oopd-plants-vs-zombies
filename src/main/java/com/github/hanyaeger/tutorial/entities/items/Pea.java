package com.github.hanyaeger.tutorial.entities.items;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import javafx.scene.input.MouseButton;

public class Pea extends DynamicSpriteEntity {
    public Pea(Coordinate2D location) {
        super("sprites/pea.png", location, new Size(20, 20));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(2, 90);
    }
}
