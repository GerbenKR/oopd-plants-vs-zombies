package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.buttons.ActionButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene {
    private PVZ pvz;

    public GameOverScene(PVZ pvz) {
        this.pvz = pvz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/default-screen.png");
    }

    public void setupEntities(){
        TextEntity title = new TextEntity(new Coordinate2D(getWidth() / 2, 80), "Game Over");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.DARKRED);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
        addEntity(title);

        TextEntity subtitle = new TextEntity(new Coordinate2D(getWidth() / 2, 150), "Your journey ends here... but you can always try again!");
        subtitle.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        subtitle.setFill(Color.WHITE);
        subtitle.setFont(Font.font("Roboto", FontWeight.MEDIUM, 24));
        addEntity(subtitle);

        ActionButton playAgain = new ActionButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Play again",
                () -> pvz.setActiveScene(2)
        );
        addEntity(playAgain);

        ActionButton returnToHome = new ActionButton(
                new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 50),
                "Return to Main Menu",
                () -> pvz.setActiveScene(1)
        );
        addEntity(returnToHome);
    }
}

