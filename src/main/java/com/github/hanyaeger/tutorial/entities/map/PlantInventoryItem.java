package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PlantInventoryItem extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private int plantId;
    private FirstLevel level;

    public PlantInventoryItem(Coordinate2D position, Size size, Object[] configuration) {
        super(position, size);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        setFill(Color.SADDLEBROWN);
        setWidth(100);
        setHeight(85);

        if(configuration != null && configuration.length >= 2) {}
        this.level = (FirstLevel) configuration[0];
        this.plantId =(int) configuration[1];
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        this.level.setSelectedPlantId(this.plantId);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        setStrokeWidth(10);
        setStrokeColor(Color.BLACK);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        setStrokeColor(Color.SADDLEBROWN);
    }
}
