package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.PVZ;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartGameButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private PVZ pvz;

    public StartGameButton(Coordinate2D position, PVZ pvz) {
        super(position, "Start het spel");
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.pvz = pvz;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        pvz.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DARKGREEN);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }
}
