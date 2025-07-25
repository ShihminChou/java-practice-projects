package com.example.Sprite.TenCommandmentSprite;

import com.example.Sprite.Sprite;

import javax.swing.*;

public class TenCommandment extends Sprite {
    public TenCommandment(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/stone.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
