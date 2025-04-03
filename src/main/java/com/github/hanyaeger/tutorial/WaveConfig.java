package com.github.hanyaeger.tutorial;

public class WaveConfig {
    private WaveType waveType;
    private int durationMs;
    private int spawnRateMs;

    public enum WaveType {
        WAITING,
        WAVE,
        FINAL_WAVE,
    }

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
