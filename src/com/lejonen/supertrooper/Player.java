package com.lejonen.supertrooper;

import java.util.ArrayList;
import java.util.List;

public class Player {

    double x;
    double y;
    double speed;
    int score;
    int life;
    boolean isAlive;
    int level;
    int nextLevel;

    public char character;

    //To do: Player skall räkna sina liv. Variabeln life skall ha en set- och en getmetod.
    //To do: 99 liv är max.

    //To do: Player behöver hålla koll på sin position (x,y). Positionen behöver ha en set- och getmetod.

    public Player (double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.score = 0;
        this.life = 3;
        this.isAlive = true;
        this.character='=';
        this.nextLevel = 50;


    }

    public void levelUp() {
        Game.level++;
        nextLevel+=50;
    }

    public void addScore(int scoreToAdd) {
        score += scoreToAdd;
    }

    public void moveLeft() {

        x -= this.speed;
    }

    public void moveRight() {

        x += this.speed;
    }

    public void shoot(List<Shot> shots) {

        shots.add(new Shot(x, y, 0.5));
    }




}
