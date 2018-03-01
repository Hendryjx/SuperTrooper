package com.lejonen.supertrooper;

import java.util.List;

public abstract class Creature {

    double x;
    double y;
    double speed = 0.05;
    public char character;

    //To do: Lägg till färg för varje klass av creature.
    //To do: Nya creatures med annorlunda rörelsemönster.
    //To do: Vapen power-up.

    public Creature(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Creature() {
    }

    public static void moveCreature(Creature creature) {

        creature.y += creature.speed*Game.level;
    }

    public static void levelUpCreatures(List<Creature> creatures) {

        for (int i = creatures.size()-1; i>=0; i--) {
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
    }
}

class SlowEnemy extends Enemy {

    public SlowEnemy(double x, double y) {
        super(x, y);
        this.character = '\u2622';
        this.value = 1;
    }
}

class PowerUp extends Creature {

    public PowerUp() {
    }

    public PowerUp(double x, double y) {

        super(x, y);
        this.character = '\u269d';

    }
}

class ExtraLife extends PowerUp {

    public ExtraLife(double x, double y) {

        super(x, y);
        this.character = '\u2764';

    }
}

class WeaponBoost extends PowerUp {

}