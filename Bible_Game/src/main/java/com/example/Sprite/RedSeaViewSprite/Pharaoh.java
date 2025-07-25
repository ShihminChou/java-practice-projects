package com.example.Sprite.RedSeaViewSprite;

import com.example.Sprite.Sprite;

import javax.swing.*;

public class Pharaoh extends Sprite {
    public Pharaoh(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/pharaoh.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
