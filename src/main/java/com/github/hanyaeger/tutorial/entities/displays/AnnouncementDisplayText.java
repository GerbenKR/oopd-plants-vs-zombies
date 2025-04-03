package com.github.hanyaeger.tutorial.entities.displays;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.animation.PauseTransition;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class AnnouncementDisplayText extends TextEntity {

    public AnnouncementDisplayText(Coordinate2D initialLocation) {
        super(initialLocation);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 40));
        setFill(Color.BLACK);
    }

    public void showAnnouncement(String text, long durationMs) {
        setText(text);

        PauseTransition pause = new PauseTransition(Duration.millis(durationMs));
        pause.setOnFinished(event -> setText(""));
        pause.play();
    }
}
