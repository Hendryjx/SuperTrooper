package com.lejonen.supertrooper;

import java.util.ArrayList;
import java.util.List;

public class Player {

    double x;
    double y;
    double speed;

    String[] sprite;

    //Player skall räkna sina liv. Variabeln life skall ha en set- och en getmetod.
    //99 liv är max.

    //Player behöver hålla koll på sin position (x,y). Positionen behöver ha en set- och getmetod.

    public Player (double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.sprite[0] = "===";

    }//Player behöver en konstruktor.

    //Player skall enbart röra sig i sidled via knapptryckningar. Rörelsen sker i floatvärden.

    //Player skall kunna skjuta vid input.



}
