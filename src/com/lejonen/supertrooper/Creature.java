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
}

class Enemy extends Creature {
    //Enemy är skadlig.

}

class FastEnemy extends Enemy {


    public FastEnemy() {
        this.character = 'X';
    }
}

class SlowEnemy extends Enemy {

    public SlowEnemy() {
        this.character = 'O';

    }
}

class PowerUp extends Creature {

}

class ExtraLife extends PowerUp {

}

class WeaponBoost extends PowerUp {


}
