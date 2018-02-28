package com.lejonen.supertrooper;

import java.util.ArrayList;
import java.util.List;

public class Player {

    double x;
    double y;
    double speed;

    public char character;


    //Player skall räkna sina liv. Variabeln life skall ha en set- och en getmetod.
    //99 liv är max.

    //Player behöver hålla koll på sin position (x,y). Positionen behöver ha en set- och getmetod.

    public Player (double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.character='=';

    }//Player behöver en konstruktor.

    //Player skall enbart röra sig i sidled via knapptryckningar. Rörelsen sker i floatvärden.

    public void moveLeft() {
        this.x -= this.speed;
    }

    public void moveRight() {
        this.x += this.speed;
    }

    public void shoot(List<Shot> shots) {
        shots.add(new Shot(this.x, this.y, 0.5));
    }

    //Player skall kunna skjuta vid input.



}
