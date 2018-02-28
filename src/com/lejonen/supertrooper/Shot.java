package com.lejonen.supertrooper;

import java.util.ArrayList;
import java.util.List;

public class Shot {

    double x;
    double y;
    double speed;
    double deltax;
    double deltay;

    public char character;

    public Shot(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.character = '|';
    }

    public static void moveShot(Shot shot) {

        shot.y -= shot.speed;

    }

}
