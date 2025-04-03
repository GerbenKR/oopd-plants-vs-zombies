package com.github.hanyaeger.tutorial.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.WaveConfig;
import com.github.hanyaeger.tutorial.entities.zombies.Zombie;
import com.github.hanyaeger.tutorial.enums.ZombieType;
import com.github.hanyaeger.tutorial.enums.WaveType;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import java.util.List;
import java.util.Random;

public class ZombieSpawner extends EntitySpawner {
    private FirstLevel firstLevel;
    private PVZ pvz;

    private final List<WaveConfig> waveConfigs;
    private int waveIndex = 0;
    private long waveStartTime;
    private long lastSpawnTime;
    private boolean finalWaveLogged = false;

    public ZombieSpawner(PVZ pvz, FirstLevel firstLevel, List<WaveConfig> waveConfigs) {
//        We start with a interval of 0ms, in the method spawnEntities() we set the interval based on the given spawn rate via WaveConfig for each wave
    super(0);

    this.pvz = pvz;
        this.firstLevel = firstLevel;

        this.waveConfigs = waveConfigs;
        this.waveStartTime = System.currentTimeMillis();
        this.lastSpawnTime = 0;

    }

    @Override
    protected void spawnEntities() {
        if (allWavesCompleted()) return;

        var currentWave = waveConfigs.get(waveIndex);
        long now = System.currentTimeMillis();

        if (isWaitingWave(currentWave)) {
            handleWaitingWave(currentWave, now);
            return;
        }

        if (isFinalWave(currentWave)) {
            firstLevel.setFinalWave(true);
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
        return wave.getWaveType() == WaveType.WAITING;
    }

    private boolean isFinalWave(WaveConfig wave) {
        return wave.getWaveType() == WaveType.FINAL_WAVE;
    }

    private void showFinalWaveStartingAnnouncement() {
        if (!finalWaveLogged) {
            this.firstLevel.announcementDisplayText.showAnnouncement("The final wave is starting!", 3_000);
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

            var spawnPosition = getRandomCellPosition();
            var zombieType = getRandomZombieType();

            try {
                Zombie zombie = zombieType.getZombieClass()
                        .getConstructor(pvz.getClass(), firstLevel.getClass(), Coordinate2D.class)
                        .newInstance(pvz, firstLevel, spawnPosition);
                spawn(zombie);

                // Increase the zombie count
                firstLevel.setZombieCount(firstLevel.getZombieCount() + 1);
            } catch (Exception e) {
                // Not ideal for production, but we aren't using any logger, so for this exersise it's ok i think
                e.printStackTrace();
            }
        }
    }

    private Coordinate2D getRandomCellPosition() {
        int row = new Random().nextInt(5);
        double x = 750;
        double y = 50 + row * 70;
        return new Coordinate2D(x, y);
    }

    private ZombieType getRandomZombieType() {
        ZombieType[] types = ZombieType.values();
        return types[new Random().nextInt(types.length)];
    }
}
