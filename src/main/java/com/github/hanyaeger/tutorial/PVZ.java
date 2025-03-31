package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.StartScreen;

public class PVZ extends YaegerGame {
    @Override
    public void setupGame() {
        setGameTitle("Planten tegen zombies");
        setSize(new Size(1280, 720));
    }

    @Override
    public void setupScenes() {
        addScene(0, new StartScreen(this));
        addScene(1, new StartScreen(this));
    }
}
