package com.lejonen.supertrooper;

import java.util.List;

public class Player {

    double x;
    double y;
    double speed;
    int score;
    int life;
    boolean isAlive;
    int nextLevel;

    public char character;

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

        if (x < 3)
            x = 3;

        x -= this.speed;
    }

    public void moveRight() {

        if (x>Game.WIDTH-4)
            x = Game.WIDTH-4;

        x += this.speed;
    }

    public void shoot(List<Shot> shots) {

        shots.add(new Shot(x, y - 1, 0.5));
    }
}