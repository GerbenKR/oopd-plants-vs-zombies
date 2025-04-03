package com.github.hanyaeger.tutorial.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.WaveConfig;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.entities.zombies.ZombieType;
import java.util.List;
import java.util.Random;

public class ZombieSpawner extends EntitySpawner {
    private static final int START_COLUMN_X = 750;
    private static final int START_COLUMN_Y = 50;

    private static final int ROWS = 5;

    private static final int CELL_HEIGHT = 70;

    private List<WaveConfig> waveConfigs;
    private int waveIndex = 0;
    private long waveStartTime;
    private long lastSpawnTime;

    public ZombieSpawner(List<WaveConfig> waveConfigs) {
        super(0); // We wil set the interval later in this Class due to different waves

        this.waveConfigs = waveConfigs;
        this.waveStartTime = System.currentTimeMillis();
        this.lastSpawnTime = 0;
    }

    @Override
    protected void spawnEntities() {
//        First: check if all waves are done
//        @TODO: Is this a victory?!?!?
        if (waveIndex >= waveConfigs.size()) return;

        long now = System.currentTimeMillis();
        WaveConfig currentWave = waveConfigs.get(waveIndex);

//        If the wave type is waiting, do nothing until the time is past
        if (currentWave.getWaveType() == WaveConfig.WaveType.WAITING) {
            if (now - waveStartTime > currentWave.getDurationMs()) {
                waveIndex++;
                if (waveIndex < waveConfigs.size()) {
                    waveStartTime = now;
                    lastSpawnTime = 0;
                }
            }
            return;
        }

        // Handle end of WAVE or FINAL_WAVE
        if (now - waveStartTime > currentWave.getDurationMs()) {
            waveIndex++;
            if (waveIndex < waveConfigs.size()) {
                waveStartTime = now;
                lastSpawnTime = 0;
            }
            return;
        }

        // Spawn zombie based on spawn rate
        if (now - lastSpawnTime >= currentWave.getSpawnRateMs()) {
            lastSpawnTime = now;
            var spawnPosition = getRandomCellPosition();
            var zombieType = getRandomZombieType();

            try {
                Zombie zombie = zombieType.getZombieClass()
                        .getConstructor(Coordinate2D.class)
                        .newInstance(spawnPosition);
                spawn(zombie);
            } catch (Exception e) {
                e.printStackTrace(); // Debug, later eventueel loggen
            }
        }
    }

    private Coordinate2D getRandomCellPosition() {
        int row = new Random().nextInt(ROWS);
        double x = START_COLUMN_X;
        double y = START_COLUMN_Y + row * CELL_HEIGHT;

        return new Coordinate2D(x, y);
    }

    private ZombieType getRandomZombieType() {
        ZombieType[] types = ZombieType.values();
        return types[new Random().nextInt(types.length)];
    }
}
