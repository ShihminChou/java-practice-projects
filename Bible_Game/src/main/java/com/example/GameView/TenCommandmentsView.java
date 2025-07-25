package com.example.GameView;

import com.example.Sprite.TenCommandmentSprite.TenCommandment;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TenCommandmentsView extends GameView {

    public TenCommandmentsView() {
        img = new ImageIcon("src/main/resources/mountain.jpg");
        elements = new ArrayList<>();
        stone = new TenCommandment(5, 5);
        elements.add(stone);
    }

    public TenCommandment getStone() {
        return stone;
    }

    private TenCommandment stone;
}
