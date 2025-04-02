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

public class InventoryItemBox extends RectangleEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final InventoryItem inventoryItem;
    private final SunManager sunManager;
    private final FirstLevel level;

    public InventoryItemBox(Coordinate2D position, Size size, InventoryItem inventoryItem, SunManager sunManager, FirstLevel level) {
        super(position, size);

        this.sunManager = sunManager;
        this.inventoryItem = inventoryItem;
        this.level = level;

        drawBox();
    }

    public void drawBox() {
        setFill(Color.WHITE);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(isInventoryItemSelectable()) {
            this.level.setSelectedPlant(inventoryItem);
        }
    }

    @Override
    public void onMouseEntered() {
        if(isInventoryItemSelectable()) {
            setCursor(Cursor.HAND);
            setStrokeWidth(5);
            setStrokeColor(Color.GREEN);
        } else {
            setStrokeWidth(5);
            setStrokeColor(Color.RED);
        }
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        setStrokeWidth(0);
    }

    public boolean isInventoryItemSelectable() {
        return sunManager.getSunAmount() >= inventoryItem.getCost() && !level.getCooldownPlants().contains(inventoryItem.getId());
    }
}
