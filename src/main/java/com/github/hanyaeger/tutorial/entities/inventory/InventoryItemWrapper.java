package com.github.hanyaeger.tutorial.entities.inventory;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;

public class InventoryItemWrapper extends CompositeEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private static final double HEIGHT = 85;
    private static final double WIDTH = 100;

    private final InventoryItem inventoryItem;
    private final SunManager sunManager;
    private final FirstLevel level;
    private final InventoryItemBox inventoryItemBox = new InventoryItemBox(new Coordinate2D(0, 0), new Size(WIDTH, HEIGHT));

    public InventoryItemWrapper(InventoryItem item, int index, SunManager sunManager, FirstLevel level) {
        super(new Coordinate2D(20, 10 + (index * 100)));
        this.inventoryItem = item;
        this.level = level;
        this.sunManager = sunManager;
    }

    @Override
    protected void setupEntities() {
        var displayNameEntity = new TextEntity(new Coordinate2D(WIDTH / 2, HEIGHT / 2), inventoryItem.getName() + "(" + this.inventoryItem.getCost() + ")");
        displayNameEntity.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(inventoryItemBox);
        addEntity(displayNameEntity);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        if(isInventoryItemSelectable()) {
            inventoryItemBox.drawActiveBox();
        } else {
            inventoryItemBox.drawUnactiveBox();
        }
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        inventoryItemBox.drawDefaultBox();
    }

    public boolean isInventoryItemSelectable() {
        return sunManager.getSunAmount() >= inventoryItem.getCost() && !level.getCooldownPlants().contains(inventoryItem.getId());
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(isInventoryItemSelectable()) {
            this.level.setSelectedPlant(inventoryItem);
        }
    }
}
