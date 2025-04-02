package com.github.hanyaeger.tutorial.entities.plants;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Sunflower extends Plant {
    private SunManager manager;

    public Sunflower(Coordinate2D location) {
        super("sprites/sunflower.gif", location, 100, 50, 0);

        Timeline sunProduction = new Timeline(new KeyFrame(Duration.seconds(10), e -> generateSun(location)));
        sunProduction.setCycleCount(Timeline.INDEFINITE);
        sunProduction.play();
    }

    public void generateSun(Coordinate2D location) {
        Sun sun = new Sun(location, manager);
    }
}
