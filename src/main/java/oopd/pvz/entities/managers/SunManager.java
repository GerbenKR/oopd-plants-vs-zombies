package oopd.pvz.entities.managers;

import com.github.hanyaeger.api.Coordinate2D;
import oopd.pvz.config.Config;
import oopd.pvz.entities.displays.SunDisplayText;

public class SunManager {
    private final SunDisplayText sunDisplayText;

    private int sunAmount;

    public SunManager() {
        this.sunAmount = Config.DEFAULT_SUN_AMOUNT;
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
