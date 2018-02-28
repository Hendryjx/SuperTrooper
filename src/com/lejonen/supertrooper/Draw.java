package com.lejonen.supertrooper;

import com.googlecode.lanterna.terminal.Terminal;

public class Draw {

    public void drawPlayer(Terminal terminal, Player player){

        double x = player.x;
        double y = player.y;

        terminal.moveCursor((int )x - 1, (int) y);
        terminal.putCharacter('=');

        terminal.moveCursor((int )x, (int) y);
        terminal.putCharacter('=');

        terminal.moveCursor((int )x + 1, (int) y);
        terminal.putCharacter('=');

        terminal.clearScreen();

        //Skicka in terminal, den som skall anropa draw måste ha tillgång till terminalen redan.
        //Skicka in positioner för Player, Shot, Creature, Collision(?).
    }

    public void drawShot(Terminal terminal, Shot shot){

        double x = shot.x;
        double y = shot.y;

        terminal.moveCursor((int )x, (int) y);
        terminal.putCharacter('|');

        terminal.clearScreen();

        //Skicka in terminal, den som skall anropa draw måste ha tillgång till terminalen redan.
        //Skicka in positioner för Player, Shot, Creature, Collision(?).
    }

    public void drawCreature(Terminal terminal, Creature creature){

        double x = creature.x;
        double y = creature.y;

        terminal.moveCursor((int) x, (int) y);
        terminal.putCharacter('\u2620');

        terminal.clearScreen();

        //Skicka in terminal, den som skall anropa draw måste ha tillgång till terminalen redan.
        //Skicka in positioner för Player, Shot, Creature, Collision(?).
    }
}
