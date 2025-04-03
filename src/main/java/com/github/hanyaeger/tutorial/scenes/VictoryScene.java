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

public class VictoryScene extends StaticScene {
    private PVZ pvz;

    public VictoryScene(PVZ pvz) {
        this.pvz = pvz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/default-screen.png");
    }

    public void setupEntities(){
        var title = new TextEntity(new Coordinate2D(getWidth() / 2, 80), "Spel gewonnen!");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.DARKGREEN);
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
        addEntity(title);

        var returnToHome = new ActionButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Return to Main Menu",
                () -> pvz.setActiveScene(1)
        );
        addEntity(returnToHome);
    }
}

