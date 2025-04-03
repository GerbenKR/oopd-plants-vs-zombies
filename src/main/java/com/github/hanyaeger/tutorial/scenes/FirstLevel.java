package com.github.hanyaeger.tutorial.scenes;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.PVZ;
import com.github.hanyaeger.tutorial.config.Config;
import com.github.hanyaeger.tutorial.entities.displays.AnnouncementDisplayText;
import com.github.hanyaeger.tutorial.entities.inventory.InventoryItem;
import com.github.hanyaeger.tutorial.entities.inventory.InventoryItemWrapper;
import com.github.hanyaeger.tutorial.entities.managers.SunManager;
import com.github.hanyaeger.tutorial.WaveConfig;
import com.github.hanyaeger.tutorial.entities.map.GrassTileMap;
import com.github.hanyaeger.tutorial.entities.plants.*;
import com.github.hanyaeger.tutorial.entities.spawners.SunSpawner;
import com.github.hanyaeger.tutorial.enums.WaveType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.ArrayList;
import com.github.hanyaeger.tutorial.entities.spawners.ZombieSpawner;
import java.util.List;

public class FirstLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {
    private final PVZ pvz;
    private final SunManager sunManager = new SunManager();

    private final ArrayList<Plant> plants = new ArrayList<>();
    private final ArrayList<Integer> cooldownPlants = new ArrayList<>();
    private final ArrayList<InventoryItem> allowedPlants = new ArrayList<>();

    private final AnnouncementDisplayText announcementDisplayText = new AnnouncementDisplayText(new Coordinate2D(getWidth() / 2, getHeight() / 2));

//    This variable contains the waves this level contains
    private final List<WaveConfig> waves = List.of(
            new WaveConfig(WaveType.WAITING, 15_000, 0),        // 15 second waiting
            new WaveConfig(WaveType.WAVE, 60_000, 10_000),      // 1 minute, each 10 sec a zombie
            new WaveConfig(WaveType.WAVE, 120_000, 8_000),      // 2 minutes, each 8 sec a zombie
            new WaveConfig(WaveType.FINAL_WAVE, 30_000, 5_000)  // 30 sec, each 5 sec a zombie
    );

    private InventoryItem selectedPlant;
    private int zombieCount = 0;
    private boolean isFinalWave = false;

    public FirstLevel(PVZ pvz) {
        this.pvz = pvz;

        this.allowedPlants.add(new InventoryItem(Config.SUNFLOWER_COST, Config.SUNFLOWER_ID, Config.SUNFLOWER_NAME));
        this.allowedPlants.add(new InventoryItem(Config.PEASHOOTER_COST, Config.PEASHOOTER_ID, Config.PEASHOOTER_NAME));
        this.allowedPlants.add(new InventoryItem(Config.WALNUT_COST, Config.WALNUT_ID, Config.WALNUT_NAME));
        this.allowedPlants.add(new InventoryItem(Config.REPEATER_COST, Config.REPEATER_ID, Config.REPEATER_NAME));
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gamelevel.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(this.announcementDisplayText);
        addEntity(this.sunManager.getSunDisplayText());

        for (int index = 0; index < this.getAllowedPlants().size(); index++) {
            addEntity(new InventoryItemWrapper(this.allowedPlants.get(index), index, sunManager, this));
        }
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new ZombieSpawner(pvz, this, waves));
        addEntitySpawner(new SunSpawner(this.sunManager));
    }

    public void addSelectedPlant(Coordinate2D location) {
        switch(selectedPlant.getId()) {
            case Config.SUNFLOWER_ID:
                Plant sunflower = new Sunflower(location, this.sunManager, this);
                addEntity(sunflower);
                plants.add(sunflower);
                break;
            case Config.PEASHOOTER_ID:
                Plant peashooter = new Peashooter(location, this);
                addEntity(peashooter);
                plants.add(peashooter);
                break;
            case Config.WALNUT_ID:
                Plant walnut = new Walnut(location, this);
                addEntity(walnut);
                plants.add(walnut);
                break;
            case Config.REPEATER_ID:
                Plant repeater = new Repeater(location, this);
                addEntity(repeater);
                plants.add(repeater);
                break;
            default:
                break;
        }

        this.sunManager.subtractSun(this.selectedPlant.getCost());
        cooldownPlants.add(selectedPlant.getId());
        startCooldownTimer(selectedPlant.getId());
        this.selectedPlant = null;
    }

    private void startCooldownTimer(int plantId) {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), e -> {
            cooldownPlants.remove(Integer.valueOf(plantId));
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(1);
        timeline.play();
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new GrassTileMap(this));
    }

    public void showAnnouncement(String text, long durationMs) {
        announcementDisplayText.showAnnouncement(text, durationMs);
    }

    public ArrayList<Integer> getCooldownPlants() {
        return cooldownPlants;
    }

    public ArrayList<InventoryItem> getAllowedPlants() {
        return this.allowedPlants;
    }

    public InventoryItem getSelectedPlant() {
        return this.selectedPlant;
    }

    public void setSelectedPlant(InventoryItem selectedPlant) {
        this.selectedPlant = selectedPlant;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public int getZombieCount() {
        return zombieCount;
    }

    public void setZombieCount(int zombieCount) {
        this.zombieCount = zombieCount;
    }

    public boolean isFinalWave() {
        return isFinalWave;
    }

    public void setFinalWave(boolean finalWave) {
        isFinalWave = finalWave;
    }

}
