package com.lejonen.supertrooper;

public abstract class Creature {

    double x;
    double y;
    double speed = 0.05;
    public char character;


    //Base class.

    //Creature skall röra sig.

    //Creature skall ha en position (x, y)

    //Creature kan kollidera.
    //Creture kan skjutas sönder.

    //Lägg till färg för varje klass av creature.
    //Nya creatures med annorlunda rörelsemönster.
    //Vapen power-up.

    public Creature(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Creature() {
    }

    public static void moveCreature(Creature creature) {
        creature.y += creature.speed;
    }
}


abstract class Enemy extends Creature {

    //Enemy är skadlig.
    public Enemy(double x, double y) {
        super(x, y);
    }

    public Enemy() {
    }

}

class FastEnemy extends Enemy {

    public FastEnemy(double x, double y) {

        super(x, y);
        this.character = 'X';
        this.speed = 0.1;
    }
}

class SlowEnemy extends Enemy {

    public SlowEnemy(double x, double y) {
        super(x, y);
        this.character = 'O';
    }
}

class PowerUp extends Creature {

    public PowerUp() {
    }

    public PowerUp(double x, double y) {

        super(x, y);
        this.character = 'U';

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


