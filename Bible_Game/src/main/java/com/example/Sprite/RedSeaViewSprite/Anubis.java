package com.example.Sprite.RedSeaViewSprite;

import com.example.Sprite.Sprite;

import javax.swing.*;

public class Anubis extends Sprite {
    public Anubis(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/anubis.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
