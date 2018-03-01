package com.lejonen.supertrooper;

import com.googlecode.lanterna.terminal.Terminal;

public class Draw {

    //TODO: För varje metod, lägg till byt färg till aktuellt objekts färg.

    public static void drawPlayer(Terminal terminal, Player player){

        int x = (int) Math.round(player.x);
        int y = (int) Math.round(player.y);

        terminal.moveCursor(x - 1, y);
        terminal.putCharacter('=');

        terminal.moveCursor(x, y);
        terminal.putCharacter('=');

        terminal.moveCursor(x + 1, y);
        terminal.putCharacter('=');

    }

    public static void drawShot(Terminal terminal, Shot shot){

        int x = (int) shot.x;
        int y = (int) shot.y;

        terminal.moveCursor(x, y);
        terminal.applyForegroundColor(255, 255, 255);
        terminal.putCharacter(shot.character);

    }

    public static void drawCreature(Terminal terminal, Creature creature){

        int x = (int) creature.x;
        int y = (int) creature.y;

        terminal.moveCursor(x, y);
        terminal.applyForegroundColor(creature.colorR, creature.colorG, creature.colorB);
        terminal.putCharacter(creature.character);

    }

    public static void drawHeader(Terminal terminal, Player player) {

        String header = "SCORE: " + player.score + "        LIFE: " + player.life + "        LEVEL: " + Game.level + "       FPS: " + Game.fps;
        int x = 1;
        int y = 0;

        for (int i = 0; i < Game.WIDTH; i++) {
            terminal.moveCursor(i, y + 1);
            terminal.applyForegroundColor(255,255,255);
            terminal.putCharacter('-');
        }

        for (int k = 0; k < header.length(); k++) {
            terminal.moveCursor(x, y);
            terminal.applyForegroundColor(255,255,255);
            terminal.putCharacter(header.charAt(k));
            x += 1;
        }
    }

    public static void drawGameOver(Terminal terminal) {
        String gameOver = "Game Over";

        for (int i = 0; i<gameOver.length(); i++) {
            terminal.moveCursor(Game.WIDTH/2-(gameOver.length()/2)+i, Game.HEIGHT/2);
            terminal.applyForegroundColor(255,255,255);
            terminal.putCharacter(gameOver.charAt(i));
        }

    }

    public static void drawLevelUp(Terminal terminal) {
        String levelUp = "Level Up!";
         for (int i = 0; i<levelUp.length(); i++) {
            terminal.moveCursor(Game.WIDTH/2-(levelUp.length()/2)+i, Game.HEIGHT/2);
            terminal.applyForegroundColor(255,255,255);
            terminal.putCharacter(levelUp.charAt(i));
        }
    }
}