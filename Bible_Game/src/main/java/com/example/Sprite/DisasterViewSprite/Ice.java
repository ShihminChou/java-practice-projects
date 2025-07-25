package com.example.Sprite.DisasterViewSprite;

import com.example.Sprite.Sprite;

import javax.swing.*;

public class Ice extends Sprite {

    public Ice(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/ice.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
