package oopd.pvz;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import oopd.pvz.scenes.FirstLevelScene;
import oopd.pvz.scenes.GameOverScene;
import oopd.pvz.scenes.StartScene;
import oopd.pvz.scenes.VictoryScene;

public class PVZ extends YaegerGame {
    @Override
    public void setupGame() {
        setGameTitle("Plants vs Zombies");
        setSize(new Size(1000, 429));
    }

    @Override
    public void setupScenes() {
        addScene(0, new StartScene(this));
        addScene(1, new FirstLevelScene(this));
        addScene(2, new GameOverScene(this));
        addScene(3, new VictoryScene(this));
    }
}
