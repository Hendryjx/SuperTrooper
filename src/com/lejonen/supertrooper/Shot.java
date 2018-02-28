package com.lejonen.supertrooper;

import java.util.ArrayList;
import java.util.List;

public class Shot {

    double x;
    double y;
    double speed;
    double deltax;
    double deltay;

    List<Shot> shots = new ArrayList<>();                               //En lista med alla skott som är på skärmen och färdas.

    public Shot(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
}
