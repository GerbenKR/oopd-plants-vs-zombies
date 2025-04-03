package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.tutorial.enums.WaveType;

public class WaveConfig {
    private WaveType waveType;
    private int durationMs;
    private int spawnRateMs;

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
