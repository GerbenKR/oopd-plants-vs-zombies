package oopd.pvz;

import oopd.pvz.enums.WaveType;

public class WaveConfig {
    private final WaveType waveType;
    private final int durationMs;
    private final int spawnRateMs;

    public WaveConfig(WaveType waveType, int durationMs, int spawnRateMs) {
        this.waveType = waveType;
        this.durationMs = durationMs;
        this.spawnRateMs = spawnRateMs;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public int getSpawnRateMs() {
        return spawnRateMs;
    }

    public WaveType getWaveType() {
        return waveType;
    }
}
