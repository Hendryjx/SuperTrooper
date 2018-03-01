package com.lejonen.supertrooper;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

public abstract class Creature {

    double x;
    double y;
    double speed = 0.05;
    public char character;
    public int colorR, colorG, colorB;

    //TODO: Lägg till färg för varje klass av creature.
    //TODO: Nya creatures med annorlunda rörelsemönster.
    //TODO: Vapen power-up.

    public Creature(double x, double y) {
        this.x = x;
        this.y = y;
        this.colorR=255;
        this.colorG=255;
        this.colorB=255;
    }

    public Creature() {
    }

    public static void moveCreature(Creature creature) {

        creature.y += creature.speed * Game.level;
    }

    public static void levelUpCreatures(List<Creature> creatures) {

        for (int i = creatures.size() - 1; i >= 0; i--) {
            creatures.get(i).speed += (creatures.get(i).speed * 0.25);
        }
    }
}

abstract class Enemy extends Creature {

    public int value;

    public Enemy(double x, double y) {
        super(x, y);
    }

    public Enemy() {
    }

}

class FastEnemy extends Enemy {

    public FastEnemy(double x, double y) {

        super(x, y);
        this.character = '\u2620';
        this.speed = 0.1;
        this.value = 5;
        this.colorR = 140;
        this.colorG = 220;
        this.colorB = 240;

    }
}

class SlowEnemy extends Enemy {

    public SlowEnemy(double x, double y) {
        super(x, y);
        this.character = '\u2622';
        this.value = 1;
        this.colorR = 120;
        this.colorG = 187;
        this.colorB = 95;
    }
}

class PowerUp extends Creature {

    public PowerUp() {
    }

    public PowerUp(double x, double y) {

        super(x, y);
        this.character = '\u269d';
        this.colorR = 255;
        this.colorG = 255;
        this.colorB = 0;

    }
}

class ExtraLife extends PowerUp {

    public ExtraLife(double x, double y) {

        super(x, y);
        this.character = '\u2764';
        this.colorR = 255;
        this.colorG = 12;
        this.colorB = 40;

    }
}

class WeaponBoost extends PowerUp {

}