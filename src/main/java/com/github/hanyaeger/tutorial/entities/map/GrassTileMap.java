package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

public class GrassTileMap extends TileMap {
    private static final int ROWS = 5;
    private static final int COLS = 8;
    private final FirstLevel level;

    public GrassTileMap(FirstLevel level) {
        super(new Coordinate2D(180, 55), new Size(520, 355));
        this.level = level;
    }

    @Override
    public void setupEntities() {
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                var uniqueIdentifier = row * col + row;
                addEntity(uniqueIdentifier, GrassTile.class, level);
            }
        }
    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
        };
    }

}
