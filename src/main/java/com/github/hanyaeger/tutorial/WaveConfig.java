package com.github.hanyaeger.tutorial;

public class WaveConfig {
    private int durationMs;
    private int spawnRateMs;

    // @TODO: Misschien geen gebruik maken van wave types, maar altijd de laatste wave als final wave defineren?
    public enum WaveType {
        WAVE,
        FINAL_WAVE,
    }

    public WaveConfig(WaveType type, int durationMs, int spawnRateMs) {
        this.durationMs = durationMs;
        this.spawnRateMs = spawnRateMs;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public int getSpawnRateMs() {
        return spawnRateMs;
    }
}
