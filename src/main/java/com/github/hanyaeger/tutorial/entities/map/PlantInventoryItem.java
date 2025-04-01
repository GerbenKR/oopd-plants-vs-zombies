package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PlantInventoryItem extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    public PlantInventoryItem(Coordinate2D position, Size size) {
        super(position);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(Color.SADDLEBROWN);
        setWidth(100);
        setHeight(85);
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
