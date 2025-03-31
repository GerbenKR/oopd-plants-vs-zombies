package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class GrassTile extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    public GrassTile(Coordinate2D initialLocation, Size size) {
        super(initialLocation);
        setFill(Color.BLACK);
        setWidth(55);
        setHeight(70);
        setOpacity(0.25);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }


    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }
}