package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

public class PlantInventoryItemMap extends TileMap {
    private FirstLevel level;

    public PlantInventoryItemMap(FirstLevel level) {
        super(new Coordinate2D(20, 10), new Size(150, level.getHeight()));
        this.level = level;
    }

    @Override
    public void setupEntities() {
        for(int index = 0; index <= 4; index++) {
            addEntity(index, PlantInventoryItem.class, new Object[]{level, index});
        }
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
            {0}, {1}, {2}, {3}, {4},
        };
    }
}
