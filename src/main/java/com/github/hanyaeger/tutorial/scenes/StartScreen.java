package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.buttons.StartGameButton;
import com.github.hanyaeger.tutorial.entities.zombies.BalloonZombie;
import com.github.hanyaeger.tutorial.entities.zombies.BucketZombie;
import com.github.hanyaeger.tutorial.entities.zombies.ConeZombie;
import com.github.hanyaeger.tutorial.entities.zombies.NormalZombie;
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
        setBackgroundAudio("audio/theme.mp3");
        setBackgroundImage("backgrounds/startscreen.jpg");
    }

    @Override
    public void setupEntities() {
//        var startButton = new StartGameButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), this.pvz);
//        addEntity(startButton);

        var normalZombie = new NormalZombie(new Coordinate2D(50, 100));
        addEntity(normalZombie);

        var coneZombie = new ConeZombie(new Coordinate2D(200, 100));
        addEntity(coneZombie);

        var bucketZombie = new BucketZombie(new Coordinate2D(300, 100));
        addEntity(bucketZombie);

        var balloonZombie = new BalloonZombie(new Coordinate2D(400, 100));
        addEntity(balloonZombie);
    }
}
