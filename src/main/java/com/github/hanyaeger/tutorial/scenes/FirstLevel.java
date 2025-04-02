package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.inventory.InventoryItem;
import com.github.hanyaeger.tutorial.entities.inventory.InventoryItemWrapper;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.entities.map.GrassTileMap;
import com.github.hanyaeger.tutorial.entities.plants.PeaShooter;
import com.github.hanyaeger.tutorial.entities.plants.Plant;
import com.github.hanyaeger.tutorial.entities.plants.Sunflower;
import com.github.hanyaeger.tutorial.entities.spawners.SunSpawner;

import java.util.ArrayList;

public class FirstLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
    private PVZ pvz;
    private InventoryItem selectedPlant;
    private ArrayList<InventoryItem> allowedPlants = new ArrayList<>();
    private final SunManager sunManager = new SunManager();

    public FirstLevel(PVZ pvz) {
        this.pvz = pvz;

        this.allowedPlants.add(new InventoryItem(Config.SUNFLOWER_COST, Config.SUNFLOWER_ID, Config.SUNFLOWER_NAME));
        this.allowedPlants.add(new InventoryItem(Config.PEASHOOTER_COST, Config.PEASHOOTER_ID, Config.PEASHOOTER_NAME));
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gamelevel.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(this.sunManager.getSunDisplayText());

        for(int index = 0; index < this.allowedPlants.size(); index++) {
            addEntity(new InventoryItemWrapper(this.allowedPlants.get(index), index, sunManager, this));
        }
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new SunSpawner(this.sunManager));
    }

    public void addSelectedPlant(Coordinate2D location) {
        switch(selectedPlant.getId()) {
            case Config.SUNFLOWER_ID:
                Plant sunflower = new Sunflower(location);
                addEntity(sunflower);
                break;
            case Config.PEASHOOTER_ID:
                Plant peashooter = new PeaShooter(location);
                addEntity(peashooter);
                break;
            default:
                break;
        }

        this.sunManager.subtractSun(this.selectedPlant.getCost());
        this.selectedPlant = null;
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new GrassTileMap(this));
    }

    public ArrayList<InventoryItem> getAllowedPlants() {
        return this.allowedPlants;
    }

    public InventoryItem getSelectedPlant() {
        return this.selectedPlant;
    }

    public void setSelectedPlant(InventoryItem selectedPlant) {
        this.selectedPlant = selectedPlant;
    }
}
