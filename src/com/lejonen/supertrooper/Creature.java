package com.lejonen.supertrooper;

import java.security.PublicKey;

public abstract class Creature {

    double x;
    double y;
    double speed;
    public char character;


    //Base class.

    //Creature skall röra sig.

    //Creature skall ha en position (x, y)

    //Creature kan kollidera.
    //Creture kan skjutas sönder.

    public Creature(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;

    }

    public Creature() {

    }

    public static void moveCreature(Creature creature) {
        creature.y += creature.speed;
    }
}


class Enemy extends Creature {
    //Enemy är skadlig.

}

class FastEnemy extends Enemy {


    public FastEnemy(double x, double y, double speed) {
        this.character = 'X';

        this.x = x;
        this.y = y;
        this.speed = speed;
    }
}

class SlowEnemy extends Enemy {

    public SlowEnemy(double x, double y, double speed) {
        this.character = 'O';

        this.x = x;
        this.y = y;
        this.speed = speed;

    }
}

class PowerUp extends Creature {

    public PowerUp() {

    }

    public PowerUp(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

}

class ExtraLife extends PowerUp {

    public ExtraLife(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        this.character ='\u2764';
    }
}

class WeaponBoost extends PowerUp {


}


