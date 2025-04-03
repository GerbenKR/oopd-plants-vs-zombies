package com.github.hanyaeger.tutorial.entities.managers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.tutorial.entities.displays.SunDisplayText;
import com.github.hanyaeger.tutorial.entities.items.Sun;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;

public class SunManager {
    private int sunAmount;
    private TextEntity sunDisplay;
    private SunDisplayText sunDisplayText;

    public SunManager() {
        this.sunAmount = 50;
        this.sunDisplayText = new SunDisplayText(new Coordinate2D(200, 10));
        this.sunDisplayText.setSunDisplayText(sunAmount);
    }

    public void addSun(int amount) {
        this.sunAmount += amount;
        this.sunDisplayText.setSunDisplayText(sunAmount);
    }

    public void subtractSun(int cost) {
        this.sunAmount -= cost;
        this.sunDisplayText.setSunDisplayText(sunAmount);
    }

    public SunDisplayText getSunDisplayText() {
        return sunDisplayText;
    }
    
    public int getSunAmount() {
        return this.sunAmount;
    }
}
