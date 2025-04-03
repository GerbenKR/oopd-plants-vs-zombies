package com.github.hanyaeger.tutorial.entities.inventory;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class InventoryItemBox extends RectangleEntity {
    public InventoryItemBox(Coordinate2D position, Size size) {
        super(position, size);
        drawDefaultBox();
    }

    public void drawUnactiveBox() {
        setStrokeWidth(5);
        setStrokeColor(Color.RED);
    }

    public void drawActiveBox() {
        setStrokeWidth(5);
        setStrokeColor(Color.GREEN);
    }

    public void drawDefaultBox() {
        setFill(Color.WHITE);
        setStrokeWidth(0);
    }
}
