package com.lejonen.supertrooper;

public class Shot {

    double x;
    double y;
    double speed;
    public char character;

    //TODO: double deltax;
    //TODO: double deltay;

    public Shot(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.character = '|';
    }

    public static void moveShot(Shot shot) {

        shot.y -= shot.speed;

    }

    public static void moveBossShot(Shot shot) {

        shot.y += shot.speed;

    }

    public void setCharacter(char character) {
        this.character = character;
    }
}