package com.github.hanyaeger.tutorial.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.WaveConfig;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.entities.zombies.ZombieType;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

import java.util.List;
import java.util.Random;

public class ZombieSpawner extends EntitySpawner {
    private FirstLevel firstLevel;

    private static final int START_COLUMN_X = 750;
    private static final int START_COLUMN_Y = 50;
    private static final int ROWS = 5;
    private static final int CELL_HEIGHT = 70;

    private final List<WaveConfig> waveConfigs;
    private int waveIndex = 0;
    private long waveStartTime;
    private long lastSpawnTime;
    private boolean finalWaveLogged = false;

    public ZombieSpawner(FirstLevel firstLevel, List<WaveConfig> waveConfigs) {
        super(0); // Interval wordt per wave dynamisch bepaald

        this.firstLevel = firstLevel;

        this.waveConfigs = waveConfigs;
        this.waveStartTime = System.currentTimeMillis();
        this.lastSpawnTime = 0;
    }

    @Override
    protected void spawnEntities() {
        if (allWavesCompleted()) return;

        WaveConfig currentWave = waveConfigs.get(waveIndex);
        long now = System.currentTimeMillis();

        if (isWaitingWave(currentWave)) {
            handleWaitingWave(currentWave, now);
            return;
        }

        if (isFinalWave(currentWave)) {
            showFinalWaveStartingAnnouncement();
        }

        if (waveDurationPassed(currentWave, now)) {
            advanceToNextWave(now);
            return;
        }

        trySpawnZombie(currentWave, now);
    }

    private boolean allWavesCompleted() {
        return waveIndex >= waveConfigs.size();
    }

    private boolean isWaitingWave(WaveConfig wave) {
        return wave.getWaveType() == WaveConfig.WaveType.WAITING;
    }

    private boolean isFinalWave(WaveConfig wave) {
        return wave.getWaveType() == WaveConfig.WaveType.FINAL_WAVE;
    }

    private void showFinalWaveStartingAnnouncement() {
        if (!finalWaveLogged) {
            this.firstLevel.announcementDisplayText.setAnnouncementDisplayText("The final wave is starting!");
            finalWaveLogged = true;
        }
    }

    private boolean waveDurationPassed(WaveConfig wave, long now) {
        return now - waveStartTime > wave.getDurationMs();
    }

    private void handleWaitingWave(WaveConfig wave, long now) {
        if (waveDurationPassed(wave, now)) {
            advanceToNextWave(now);
        }
    }

    private void advanceToNextWave(long now) {
        waveIndex++;
        if (!allWavesCompleted()) {
            waveStartTime = now;
            lastSpawnTime = 0;
        }
    }

    private void trySpawnZombie(WaveConfig wave, long now) {
        if (now - lastSpawnTime >= wave.getSpawnRateMs()) {
            lastSpawnTime = now;

            Coordinate2D spawnPosition = getRandomCellPosition();
            ZombieType zombieType = getRandomZombieType();

            try {
                Zombie zombie = zombieType.getZombieClass()
                        .getConstructor(Coordinate2D.class)
                        .newInstance(spawnPosition);
                spawn(zombie);
            } catch (Exception e) {
                e.printStackTrace(); // Voor nu: printen. Later eventueel loggen.
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
