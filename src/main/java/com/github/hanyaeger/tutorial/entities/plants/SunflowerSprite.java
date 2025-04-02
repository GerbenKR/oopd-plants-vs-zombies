package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SunflowerSprite extends SpriteEntity {
    protected SunflowerSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(50, 50));
        setAnchorPoint(AnchorPoint.TOP_LEFT);
    }
}
