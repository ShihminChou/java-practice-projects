package com.example.Sprite;

import com.example.GameView.DisasterView;
import com.example.GameView.RedSeaGameView;
import com.example.GameView.TenCommandmentsView;
import com.example.Main;
import com.example.Sprite.DisasterViewSprite.*;
import com.example.Sprite.RedSeaViewSprite.*;
import com.example.Sprite.TenCommandmentSprite.TenCommandment;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Sprite {

    public Moses(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("src/main/resources/Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView) {
            // check for bugs ang frogs
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            for (Bug b : bugs) {
                if (b.getRelativePosition() != null && x == b.getRelativePosition().x && y == b.getRelativePosition().y) {
                    return "Die";
                }
            }
            for (Frog f : frogs) {
                if (f.getRelativePosition() != null && x == f.getRelativePosition().x && y == f.getRelativePosition().y) {
                    return "Die";
                }
            }
            // check for ices and stones
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIceCubes();
            ArrayList<Tombstone> stones = ((DisasterView) Main.gameView).getStones();
            for (Ice i : ices) {
                if (i.getRelativePosition() != null && x == i.getRelativePosition().x && y == i.getRelativePosition().y) {
                    return "Cannot move";
                }
            }
            for (Tombstone s : stones) {
                if (s.getRelativePosition() != null && x == s.getRelativePosition().x && y == s.getRelativePosition().y) {
                    return "Cannot move";
                }
            }
            // check for door
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y) {
                return "Next level";
            }
        } else if(Main.gameView instanceof RedSeaGameView) {
            ArrayList<Anubis> anubis = ((RedSeaGameView) Main.gameView).getAnubis();
            ArrayList<Pharaoh> pharaohs = ((RedSeaGameView) Main.gameView).getPharoahs();
            for (Anubis a : anubis) {
                if (a.getRelativePosition() != null && x == a.getRelativePosition().x && y == a.getRelativePosition().y) {
                    return "Die";
                }
            }
            for (Pharaoh p : pharaohs) {
                if (p.getRelativePosition() != null && x == p.getRelativePosition().x && y == p.getRelativePosition().y) {
                    return "Die";
                }
            }

            ArrayList<Cat> cats = ((RedSeaGameView) Main.gameView).getCats();
            for (Cat c : cats) {
                if (c.getRelativePosition() != null && x == c.getRelativePosition().x && y == c.getRelativePosition().y) {
                    return "Cannot move";
                }
            }
            // check for door
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y) {
                return "Next level";
            }
        } else if (Main.gameView instanceof TenCommandmentsView) {
            TenCommandment stone = ((TenCommandmentsView) Main.gameView).getStone();
            if (x == stone.getRelativePosition().x && y == stone.getRelativePosition().y) {
                return "Game over";
            }
        }
       return "none";
    }
}
