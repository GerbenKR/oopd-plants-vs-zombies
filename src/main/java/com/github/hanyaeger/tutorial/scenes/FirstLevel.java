package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.entities.map.GrassTile;
import com.github.hanyaeger.tutorial.entities.map.GrassTileMap;
import com.github.hanyaeger.tutorial.entities.map.PlantInventoryItemMap;
import com.github.hanyaeger.tutorial.entities.plants.PeaShooter;
import com.github.hanyaeger.tutorial.entities.plants.Plant;
import com.github.hanyaeger.tutorial.entities.plants.Sunflower;

import java.util.ArrayList;

public class FirstLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
    public static final int SUNFLOWER = 1;
    public static final int PEASHOOTER = 2;

    private PVZ pvz;
    private int selectedPlantId = -1;
    private int[] allowedPlantIds = {SUNFLOWER, PEASHOOTER};
    private ArrayList<Plant> plants;


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

    public void addSelectedPlant(Coordinate2D location) {
        switch(selectedPlantId) {
            case SUNFLOWER:
                Plant sunflower = new Sunflower(location);
                addEntity(sunflower);
                break;
            case PEASHOOTER:
                Plant peashooter = new PeaShooter(location);
                addEntity(peashooter);
                break;
            default:
                break;
        }
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new GrassTileMap(this));
        addTileMap(new PlantInventoryItemMap(this));
    }

    public int[] getAllowedPlantIds() {
        return this.allowedPlantIds;
    }

    public int getSelectedPlantId() {
        return this.selectedPlantId;
    }

    public void setSelectedPlantId(int selectedPlantId) {
        this.selectedPlantId = selectedPlantId;
    }
}
