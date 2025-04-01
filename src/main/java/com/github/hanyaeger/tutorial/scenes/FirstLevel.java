package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.map.GrassTile;
import com.github.hanyaeger.tutorial.entities.map.GrassTileMap;
import com.github.hanyaeger.tutorial.entities.map.PlantInventoryItemMap;

public class FirstLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
    private PVZ pvz;

    public FirstLevel(PVZ pvz) {
        this.pvz = pvz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gamelevel.jpg");
    }

    @Override
    public void setupEntities() {
    }

    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new GrassTileMap());
        addTileMap(new PlantInventoryItemMap(this));
    }
}
