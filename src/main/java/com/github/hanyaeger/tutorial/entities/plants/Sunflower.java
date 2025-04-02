package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Sunflower extends Plant {
    private SunManager manager;

    public Sunflower(Coordinate2D location) {
        super(location, Config.SUNFLOWER_HEALTH, Config.SUNFLOWER_COST, Config.SUNFLOWER_ID);

//        Timeline sunProduction = new Timeline(new KeyFrame(Duration.seconds(10), e -> generateSun(location)));
//        sunProduction.setCycleCount(Timeline.INDEFINITE);
//        sunProduction.play();
    }

    @Override
    protected void setupEntities() {
        addEntity(new SunflowerSprite("sprites/sunflower.gif", new Coordinate2D(0, 0)));
    }
}
