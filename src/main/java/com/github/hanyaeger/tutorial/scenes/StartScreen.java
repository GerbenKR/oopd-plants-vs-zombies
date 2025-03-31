package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.buttons.StartGameButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScreen extends StaticScene {
    private PVZ pvz;

    public StartScreen(PVZ pvz) {
        this.pvz = pvz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/startscreen.jpg");
    }

    @Override
    public void setupEntities() {
        var startButton = new StartGameButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 60), this.pvz);
        addEntity(startButton);
    }
}
