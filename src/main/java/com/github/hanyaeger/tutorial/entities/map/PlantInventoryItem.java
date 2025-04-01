package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PlantInventoryItem extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private int plantId;

    public PlantInventoryItem(Coordinate2D position, Size size, Integer plantId) {
        super(position, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(Color.SADDLEBROWN);
        setWidth(100);
        setHeight(85);
        this.plantId = plantId;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        setStrokeColor(Color.BROWN);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        setStrokeColor(Color.SADDLEBROWN);
    }
}
