package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.WaveConfig;
import com.github.hanyaeger.tutorial.entities.map.GrassTile;
import com.github.hanyaeger.tutorial.entities.map.GrassTileMap;
import com.github.hanyaeger.tutorial.spawners.ZombieSpawner;

import java.util.List;

public class FirstLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
    private PVZ pvz;

    private List<WaveConfig> waves = List.of(
            new WaveConfig(WaveConfig.WaveType.WAVE, 60_000, 10_000),    // 1 minuut, elke 10 sec een zombie
            new WaveConfig(WaveConfig.WaveType.WAVE, 120_000, 8_000),   // 2 minuten, elke 9 sec een zombie
            new WaveConfig(WaveConfig.WaveType.FINAL_WAVE, 30_000, 5_000)     // 30 sec, elke 5 sec een zombie
    );

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
        addEntitySpawner(new ZombieSpawner(waves));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new GrassTileMap());
    }
}
