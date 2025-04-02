package com.github.hanyaeger.tutorial.entities.inventory;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

public class InventoryItemWrapper extends CompositeEntity {
    private static final int HEIGHT = 85;
    private static final int WIDTH = 100;

    private InventoryItem inventoryItem;
    private SunManager sunManager;
    private FirstLevel level;

    public InventoryItemWrapper(InventoryItem item, int index, SunManager sunManager, FirstLevel level) {
        super(new Coordinate2D(20, 10 + (index * 100)));
        this.inventoryItem = item;
        this.level = level;
        this.sunManager = sunManager;
    }

    @Override
    protected void setupEntities() {
        var displayNameEntity = new TextEntity(new Coordinate2D(WIDTH / 2, HEIGHT / 2), inventoryItem.getName());
        displayNameEntity.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(new InventoryItemBox(new Coordinate2D(0, 0), new Size(WIDTH, HEIGHT), inventoryItem, sunManager, level));
        addEntity(displayNameEntity);
    }
}
