package com.github.hanyaeger.tutorial.entities.displays;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AnnouncementDisplayText extends TextEntity {
    public AnnouncementDisplayText(Coordinate2D initialLocation) {
        super(initialLocation);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 40));
        setFill(Color.BLACK);
    }

    public void setAnnouncementDisplayText(String text) {
        //        When setText() is triggered, the AnchorPoint is reset by Yeager (idk why)
        //        So we need to set it again (:
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        setText(text);
    }
}
