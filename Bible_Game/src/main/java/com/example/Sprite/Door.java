package com.example.Sprite;

import javax.swing.*;

public class Door extends Sprite {

    public Door(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/door.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
