package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.FirstLevel;
import com.github.hanyaeger.tutorial.scenes.GameOverScene;
import com.github.hanyaeger.tutorial.scenes.StartScreen;
import com.github.hanyaeger.tutorial.scenes.VictoryScene;

public class PVZ extends YaegerGame {
    @Override
    public void setupGame() {
        setGameTitle("Planten tegen zombies");
        setSize(new Size(1000, 429));
    }

    @Override
    public void setupScenes() {
        addScene(0, new StartScreen(this));
        addScene(1, new FirstLevel(this));
        addScene(2, new GameOverScene(this));
        addScene(3, new VictoryScene(this));
    }
}
