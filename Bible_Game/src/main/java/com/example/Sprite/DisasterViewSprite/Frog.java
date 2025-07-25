package com.example.Sprite.DisasterViewSprite;

import com.example.Sprite.Sprite;
import javax.swing.*;

public class Frog extends Sprite {

    public Frog(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/frog.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
