package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.entities.plants.Plant;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class GrassTile extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final FirstLevel level;
    private final Coordinate2D position;

    public GrassTile(Coordinate2D position, Size size, FirstLevel level) {
        super(position);
        this.position = new Coordinate2D(position.getX() + 30, position.getY() + 35);
        this.level = level;
        setupGrassTile();
    }

    public void setupGrassTile() {
        setFill(Color.WHITE);
        setWidth(55);
        setHeight(70);
        setOpacity(0);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        boolean isGrassTileOccupied = false;
        for (Plant plant : level.getPlants()) {
            if(plant.getLocation().getX() == this.position.getX() && plant.getLocation().getY() == this.position.getY()) {
                isGrassTileOccupied = true;
            }
        }

        if(this.level.getSelectedPlant() != null && !isGrassTileOccupied) {
            this.level.addSelectedPlant(this.position);
        }
    }

    @Override
    public void onMouseEntered() {
        if(this.level.getSelectedPlant() != null) {
            setCursor(Cursor.HAND);
            setOpacity(0.25);
        }
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        setOpacity(0);
    }
}