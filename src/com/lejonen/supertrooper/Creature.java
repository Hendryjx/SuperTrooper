package com.lejonen.supertrooper;

public abstract class Creature {

    //Base class.

    //Creature skall röra sig.

    //Creature skall ha en position (x, y)

    //Creature kan kollidera.
    //Creture kan skjutas sönder.

}

class Enemy extends Creature {
    //Enemy är skadlig.
    //Vi

}

class FastEnemy extends Enemy{

}

class SlowEnemy extends Enemy {

}

class PowerUp extends Creature {

}

class ExtraLife extends PowerUp {

}

class WeaponBoost extends PowerUp {


}