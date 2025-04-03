package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.buttons.ActionButton;

public class StartScene extends StaticScene {
    private final PVZ pvz;

    public StartScene(PVZ pvz) {
        this.pvz = pvz;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/theme.mp3");
        setBackgroundImage("backgrounds/startscreen.jpg");
    }

    @Override
    public void setupEntities() {
        var playAgain = new ActionButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Play the game",
                () -> pvz.setActiveScene(1)
        );
        addEntity(playAgain);
    }
}
