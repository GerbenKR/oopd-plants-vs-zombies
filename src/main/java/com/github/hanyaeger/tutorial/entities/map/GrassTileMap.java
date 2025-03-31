package com.github.hanyaeger.tutorial.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.TileMap;

public class GrassTileMap extends TileMap {
    private static int ROWS = 5;
    private static int COLS = 8;

    public GrassTileMap() {
        super(new Coordinate2D(180, 55), new Size(520, 355));
    }

    @Override
    public void setupEntities() {
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                var uniqueIdentifier = row * col + row;
                addEntity(uniqueIdentifier, GrassTile.class);
            }
        }
    }

    @Override
    public int[][] defineMap() {
        int[][] map = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
        };
        return map;
    }

}
