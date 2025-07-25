package com.example.Sprite.RedSeaViewSprite;

import com.example.Sprite.Sprite;

import javax.swing.*;

public class Cat extends Sprite {
    public Cat(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/cat.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
